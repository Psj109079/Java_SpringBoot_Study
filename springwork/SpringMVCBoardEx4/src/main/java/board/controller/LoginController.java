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
		
		// 로그인 여부를 판단할 세션
		String loginok = (String)session.getAttribute("loginok");
		
		if(loginok == null) {
			return "login/login";			
		} else {
			return "login/logout";						
		}
	}
	
	@PostMapping("/login/loginaction")
	public String login(@RequestParam String email, @RequestParam String pass,
			@RequestParam(required = false) String saveemail,/* 체크 안했을 경우 null 값으로 넘어온다
			@RequestParam(defaultValue = "no") String saveemail 체크 안했을 경우 no 값으로 넘어온다*/
			HttpSession session) {
		// 이메일과 비밀번호가 맞는지 체크
		int count = memberDao.isEqualPassEmail(email, pass);
		if(count == 1) { // 이메일과 비밀번호가 맞는경우 1
			// 로그인 성공시  세션에 저장하기
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
