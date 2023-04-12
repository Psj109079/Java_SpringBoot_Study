package board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import board.dao.AnswerDao;
import board.dao.BoardDao;
import board.dao.MemberDao;
import board.dto.BoardDto;
import board.dto.MemberDto;

@Controller
public class BoardController {
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	AnswerDao answerDao;
	
	@GetMapping("/board/form")
	public String form() {
		return "board/form";
	}
	
	@PostMapping("board/addboard")
	public String insertBoard(@ModelAttribute BoardDto dto, @RequestParam ArrayList<MultipartFile> upload, HttpServletRequest request, HttpSession session ) {
		// 세션에 저장된 이메일
		String email = (String)session.getAttribute("loginemail");
		// 그 이메일에 해당하는 member테이블의 num 값
		int num = memberDao.selectOneOfEmail(email).getNum();
		// dto에 저장
		dto.setNum(num);
		
		// 업로드할 경로
		String realPath = request.getSession().getServletContext().getRealPath("/resources/photo");
		String images = "";
		System.out.println(realPath);
		// 사진을 업로드 하지 않았을경우 db에 no라고 저장하기
		// 업로드 했을경우 파일명을 날짜로 변경해보기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHss");
		String fname = sdf.format(new Date());
		
		if(upload.get(0).getOriginalFilename().equals("")) { // 업로드를 안한경우
			images = "no";
		} else {
			int i = 0;
			for(MultipartFile mfile : upload) {
				String originalName = mfile.getOriginalFilename();
				// . 기준으로 나누기
				StringTokenizer st = new StringTokenizer(originalName, ".");
				String fileName = st.nextToken();
				String extName = st.nextToken();
				System.out.println(fileName + "," + extName);
				// 파일명을  날짜로 변경하기 (뒤에 인덱스 붙히기)
				fileName = fname +  "_" + i++ + "." + extName;
				System.out.println(fileName); // 업로드할 최종 파일명
				
				images += fileName + ",";
				
				// 사진 업로드
				try {
					mfile.transferTo(new File(realPath + "/" + fileName));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 마지막 컴마 제거
			images = images.substring(0, images.length() - 1);
		}
		// dto 에 photo 값 저장
		dto.setImages(images);
		
		// db 에 저장
		boardDao.insertBoard(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/board/list")
	public String list(HttpSession session, Model model, @RequestParam(defaultValue = "1") int currentPage /* 페이지 번호가 넘어오지 않을경우 무조건 1페이지를 보여줌 */) {
		
		
		String email = (String) session.getAttribute("loginemail");
		MemberDto dto = memberDao.selectOneOfEmail(email);
		
		model.addAttribute("dto", dto);
		
		// 게시판의 총 글갯수 얻기
		int totalCount = boardDao.getTotalCount();
		int totalPage; // 총 페이지 수
		int perPage = 3; // 한 페이지당 보여질 글의 갯수
		int perBlock = 3; // 한 블럭당 보여질 페이지의 갯수
		int startNum; // 각 페이지에서 보여질 글의 시작번호
		int startPage; // 각 블럭에서 보여질 시작 페이지 번호
		int endPage; // 각 블럭에서 보여질 끝 페이지 번호
		int no; // 글 출력시 출력할 시작번호
		
		// 총 페이지 수 
		totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);
		// 시작페이지
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		// 끝 페이지
		endPage = startPage + perBlock - 1;
		// 이때 문제점.... endPage가 
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		// 각 페이지의 시작번호(1페이지: 0, 2페이지: 3, 3페이지 : 6....)
		startNum = (currentPage - 1) * perPage;
		// 각 글마다 출력할 글 번호(예: 10개일 경우 1페이지: 10, 2페이지: 7....)
		no = totalCount - startNum;
		
		// 각 페이지에 필요할 개시글 db에서 가져오기
		List<BoardDto> list = boardDao.getPagingList(startNum, perPage);
		// 각 게시글에 글쓴 사람의 name 을 dto에 저장
		for(BoardDto bdto : list) {
			// 글쓴 사람의 num
			int num = bdto.getNum();
			// num에 해당하는 사람의 이름
			String name = "";	
			try {
				// num에 해당하는 데이터가 없을경우 NullPointerException 발생
				name = memberDao.selectOneOfNum(num).getName();				
			} catch (NullPointerException e) {
				name = "탈퇴한회원";
			}
			//bdto에 저장
			bdto.setName(name);
			// 댓글갯수 acount에 저장
			int acount = answerDao.getAllAnswers(bdto.getIdx()).size();
			bdto.setAcount(acount);
					
		}
		
		// 출력 시 필요한 변수들을 model에 모두 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("no", no);
		
		return "board/list";
	}
	
	@GetMapping("/board/content")
	public String content(Model model, @RequestParam int idx, @RequestParam int currentPage) {
		// 조회수 증가
		boardDao.updateReadCount(idx);
		
		// board 테이블의 dto 데이터 얻기
		BoardDto bdto = boardDao.selectOneBoard(idx);
		
		// num 에 해당하는 name, photo 얻기
//		MemberDto mdto = memberDao.selectOneOfNum(bdto.getNum());
//		bdto.setName(mdto.getName());
//		bdto.setPhoto(mdto.getPhoto());
		String name = "";
		String photo = "";
				
		try {
			name = memberDao.selectOneOfNum(bdto.getNum()).getName();
			photo = memberDao.selectOneOfNum(bdto.getNum()).getPhoto();
			
			bdto.setName(name);
			bdto.setPhoto(photo);
		} catch(NullPointerException e) {
			bdto.setName("탈퇴한 회원");
			bdto.setPhoto("noimage.png");
		}
		
		// model 에 dto.currentPage를 저장
		model.addAttribute("dto", bdto);
		model.addAttribute("currentPage", currentPage);
		return "board/content";
	}
	
	@GetMapping("/board/delete")
	public String delete(@RequestParam int idx, @RequestParam int currentPage) {
		// 삭제 후 보던 페이지 목록으로 이동
		boardDao.deleteOfBoard(idx);
		return "redirect:list?currentPage=" + currentPage;
	}
	
	@GetMapping("/board/updateform")
	public String updateform(@RequestParam int idx, @RequestParam int currentPage, @ModelAttribute BoardDto dto, Model model) {
		System.out.println(idx);
		System.out.println(currentPage);
		dto = boardDao.selectOneBoard(idx);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("dto", dto);
		return "board/updateform";
	}
	
	@PostMapping("/board/updateboard")
	public String updateBoard(@RequestParam int currentPage, @ModelAttribute BoardDto dto, @RequestParam ArrayList<MultipartFile> upload, HttpServletRequest request) {
		
		// 업로드할 경로
		String realPath = request.getSession().getServletContext().getRealPath("/resources/photo");
		String images = "";
		System.out.println(realPath);
		// 사진을 업로드 하지 않았을경우 db에 no라고 저장하기
		// 업로드 했을경우 파일명을 날짜로 변경해보기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHss");
		String fname = sdf.format(new Date());
				
		if(upload.get(0).getOriginalFilename().equals("")) { // 업로드를 안한경우
			images = null;
		} else {
			int i = 0;
			for(MultipartFile mfile : upload) {
				String originalName = mfile.getOriginalFilename();
				// . 기준으로 나누기
				StringTokenizer st = new StringTokenizer(originalName, ".");
				String fileName = st.nextToken();
				String extName = st.nextToken();
				System.out.println(fileName + "," + extName);
				// 파일명을  날짜로 변경하기 (뒤에 인덱스 붙히기)
				fileName = fname +  "_" + i++ + "." + extName;
				System.out.println(fileName); // 업로드할 최종 파일명
				
				images += fileName + ",";
				
				// 사진 업로드
				try {
					mfile.transferTo(new File(realPath + "/" + fileName));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 마지막 컴마 제거
			images = images.substring(0, images.length() - 1);
		}
		// dto 에 photo 값 저장
		dto.setImages(images);
				
		boardDao.updateBoard(dto);
		
		return "redirect:content?idx=" + dto.getIdx() + "&currentPage=" + currentPage;
	}
	
}
