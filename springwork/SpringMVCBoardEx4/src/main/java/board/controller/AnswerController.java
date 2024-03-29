package board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import board.dao.AnswerDao;
import board.dao.MemberDao;
import board.dto.AnswerDto;

@RestController
public class AnswerController {
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	AnswerDao answerDao;
	
	// 댓글 insert
	@GetMapping("/board/ainsert")
	public void insertAnswer(@RequestParam String content, @RequestParam int idx, HttpSession session) {
		// 세션에 저장된 num값을 얻는다
//		String num = (String)session.getAttribute("loginnum");
//		int num = Integer.parseInt(snum);  @RequestParam int num
		// session 객체는 int형으로 담을 수 없음 
		Integer num = (Integer)session.getAttribute("loginnum");
		System.out.println(num);
		// dto에 담기
		AnswerDto dto = new AnswerDto();
		dto.setContent(content);
		dto.setIdx(idx);
		dto.setNum(num);
		
		answerDao.insertAnswer(dto);
	}
	
	// 댓글 전체 list
	@GetMapping("/board/alist")
	public List<AnswerDto> getAllAnswer(@RequestParam int idx) {
		
		List<AnswerDto> list = answerDao.getAllAnswers(idx); // list가 json 형태로 반환
		for(AnswerDto dto:list) {
			try {
				// member 테이블로부터 name,photo를 얻어서 dto에 넣는다
				String name = memberDao.selectOneOfNum(dto.getNum()).getName();
				String photo = memberDao.selectOneOfNum(dto.getNum()).getPhoto();
				
				dto.setName(name);
				dto.setPhoto(photo);				
			} catch (NullPointerException e) {
				dto.setName("탈퇴한회원");
				dto.setPhoto("noimage2.png");				
			}
		}
		return list;
	}
	
	@GetMapping("/board/deleteanswer")
	public void delete(@RequestParam int seq) {
		answerDao.deleteAnswer(seq);
	}
}
