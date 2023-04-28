package boot.study.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import boot.study.dto.BoardDto;
import boot.study.service.BoardService;
import naver.cloud.NcpObjectStorageService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private NcpObjectStorageService storageService;
	
	// 버켓이름지정
	//private String bucketName = "bit701-bucket-106"; // 각자 클라우드 버킷이름
	private String bucketName="bit701-bucket-106";

	@GetMapping("/list")
	public String list(@RequestParam(defaultValue = "1") int currentPage, Model model) {

		// 게시판의 총 글갯수 얻기
		int totalCount = boardService.getTotalCount();
		int totalPage; // 총 페이지 수
		int perPage = 10; // 한 페이지당 보여질 글의 갯수
		int perBlock = 10; // 한 블럭당 보여질 페이지의 갯수
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
		// 이때 문제점.... endPage가 totalpage 보다 크면 안됨
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		// 각 페이지의 시작번호(1페이지: 0, 2페이지: 3, 3페이지 : 6....)
		startNum = (currentPage - 1) * perPage;
		// 각 글마다 출력할 글 번호(예: 10개일 경우 1페이지: 10, 2페이지: 7....)
		no = totalCount - startNum;

		// 각 페이지에 필요할 개시글 db에서 가져오기
		List<BoardDto> list = boardService.getPagingList(startNum, perPage);

		// 출력 시 필요한 변수들을 model에 모두 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("no", no);
		
		return "/main/board/boardlist";
	}
	
	// 폼이 원글 폼일수도 있고 답글 폼일수도 있음
	@GetMapping("/writeform")
	public String form(@RequestParam(defaultValue = "1") int currentPage,
			@RequestParam(defaultValue = "0") int num,
			@RequestParam(defaultValue = "0") int ref,
			@RequestParam(defaultValue = "0") int step,
			@RequestParam(defaultValue = "0") int depth,
			Model model) {
		// 답글일 경우 제목 나오게 하기 위해서 제목 구해놓기
		String subject = "";
		if(num > 0) { // 답글일경우
			subject = boardService.getData(num).getSubject();
		}
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("num", num);
		model.addAttribute("ref", ref);
		model.addAttribute("step", step);
		model.addAttribute("depth", depth);
		return "/main/board/boardform";
	}
	
	@PostMapping("/insert")
	public String insert(BoardDto dto, MultipartFile upload) {
		
		String filename="";
		// 업로드를 한 경우에만 버킷에 이미지 저장
		if(!upload.getOriginalFilename().equals("")) {
			filename = storageService.uploadFile(bucketName, "board", upload);
		}
		
		// dto에 파일명 저장
		dto.setFilename(filename);
		
		boardService.insertBoard(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/content")
	public String content(int num, int currentPage, Model model) {
		
		// 조회수 증가
		boardService.updateReadcount(num);
		
		// dto 얻기
		BoardDto dto = boardService.getData(num);
		
		// model 저장
		model.addAttribute("dto", dto);
		model.addAttribute("currentPage", currentPage);
		return "/main/board/content";
	}
	
	@GetMapping("/delete")
	@ResponseBody public Map<String, String> delete(int num, String pass) {
		Map<String, String> map = new HashMap<>();
		
		// 비번이 맞을경우 map에 result -> success 를 넣고 버킷의 사진 지우고 db 글 지우기
		// 틀릴경우 map 에 result -> fail
		boolean b =  boardService.isEqualPass(num, pass);
		if(b) {
			map.put("result", "success");
			// db 삭제전에 저장된 이미지를 버켓에서 지운다
			String filename = boardService.getData(num).getFilename();
			storageService.deleteFile(bucketName, "board", filename);
			// db 삭제 
			boardService.deleteBoard(num);
		} else {
			map.put("result", "fail");
		}
		return map;
	}
	
	@GetMapping("/chkpass")
	@ResponseBody public Map<String, String> chkPass(int num, String pass) {
		Map<String, String> map = new HashMap<>();
		
		// 비번이 맞을경우 map에 result -> success 를 넣고 버킷의 사진 지우고 db 글 지우기
		// 틀릴경우 map 에 result -> fail
		boolean b =  boardService.isEqualPass(num, pass);
		if(b) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		return map;
	}
	
	@GetMapping("/updateform")
	public String updateForm(int num, int currentPage, Model model) {
		BoardDto dto = boardService.getData(num);
		
		model.addAttribute("dto", dto);
		model.addAttribute("currentPage", currentPage);
		
		return "/main/board/updateform";
	}
	
	@PostMapping("/update")
	public String update(BoardDto dto, MultipartFile upload, int currentPage) {
		String filename = "";
		
		// 사진선택을 한 경우에는 기존 사진을 버킷에서 지우고 다시 업로드
		if(!upload.getOriginalFilename().equals("")) {
			// 기존 파일명 알아내기
			filename = boardService.getData(dto.getNum()).getFilename();
			// 버킷에서 삭제
			storageService.deleteFile(bucketName, "board", filename);
			
			// 다시 업로드
			filename = storageService.uploadFile(bucketName, "board", upload);
		}
		dto.setFilename(filename);
		
		// 수정
		boardService.updateBoard(dto);
		
		return "redirect:content?currentPage=" + currentPage + "&num=" + dto.getNum();
	}
}
