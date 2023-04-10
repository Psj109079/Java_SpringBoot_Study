package board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.dao.MemberDao;

@Controller
public class LoginController {
	
	@Autowired
	MemberDao memberDao;
	
	@GetMapping("/login/form")
	public String login(HttpSession session) {
		
		// �α��� ���θ� �Ǵ��� ����
		String loginok = (String)session.getAttribute("loginok");
		
		if(loginok == null) {
			return "login/login";			
		} else {
			return "login/logout";						
		}
	}
	
	@PostMapping("/login/loginaction")
	public String login(@RequestParam String email, @RequestParam String pass,
			@RequestParam(required = false) String saveemail,/* üũ ������ ��� null ������ �Ѿ�´�
			@RequestParam(defaultValue = "no") String saveemail üũ ������ ��� no ������ �Ѿ�´�*/
			HttpSession session) {
		// �̸��ϰ� ��й�ȣ�� �´��� üũ
		int count = memberDao.isEqualPassEmail(email, pass);
		if(count == 1) { // �̸��ϰ� ��й�ȣ�� �´°�� 1
			// �α��� ������  ���ǿ� �����ϱ�
			session.setAttribute("loginok", "yes");
			session.setAttribute("loginemail", email);
			session.setAttribute("saveemail", saveemail == null ? "no" : "yes");
			return "redirect:../board/list";
		} else {
			return "login/loginfail";
		}
	}
	
	@GetMapping("/login/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginok");
		session.removeAttribute("loginemail");
		return "redirect:form";
	}
}
