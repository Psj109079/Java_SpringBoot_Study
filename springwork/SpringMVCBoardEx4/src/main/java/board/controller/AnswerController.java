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
	
	// ��� insert
	@GetMapping("/board/ainsert")
	public void insertAnswer(@RequestParam String content, @RequestParam int idx, HttpSession session) {
		// ���ǿ� ����� num���� ��´�
//		String num = (String)session.getAttribute("loginnum");
//		int num = Integer.parseInt(snum);  @RequestParam int num
		// session ��ü�� int������ ���� �� ���� 
		Integer num = (Integer)session.getAttribute("loginnum");
		System.out.println(num);
		// dto�� ���
		AnswerDto dto = new AnswerDto();
		dto.setContent(content);
		dto.setIdx(idx);
		dto.setNum(num);
		
		answerDao.insertAnswer(dto);
	}
	
	// ��� ��ü list
	@GetMapping("/board/alist")
	public List<AnswerDto> getAllAnswer(@RequestParam int idx) {
		
		List<AnswerDto> list = answerDao.getAllAnswers(idx); // list�� json ���·� ��ȯ
		for(AnswerDto dto:list) {
			try {
				// member ���̺�κ��� name,photo�� �� dto�� �ִ´�
				String name = memberDao.selectOneOfNum(dto.getNum()).getName();
				String photo = memberDao.selectOneOfNum(dto.getNum()).getPhoto();
				
				dto.setName(name);
				dto.setPhoto(photo);				
			} catch (NullPointerException e) {
				dto.setName("Ż����ȸ��");
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
