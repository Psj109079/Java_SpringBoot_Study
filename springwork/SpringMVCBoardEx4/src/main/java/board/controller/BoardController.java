package board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import board.dao.BoardDao;
import board.dao.MemberDao;
import board.dto.MemberDto;

@Controller
public class BoardController {
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	BoardDao boardDao;
	
	@GetMapping("/board/form")
	public String form() {
		return "board/form";
	}
	
	@GetMapping("/board/list")
	public String list(HttpSession session, Model model) {
		
		String email = (String) session.getAttribute("loginemail");
		MemberDto dto = memberDao.selectOneOfEmail(email);
		
		model.addAttribute("dto", dto);
		
		// �Խ����� �� �۰��� ���
		int totalCount = boardDao.getTotalCount();
		model.addAttribute("totalCount", totalCount);
		
		return "board/list";
	}
}
