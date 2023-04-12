package rs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	
	@GetMapping("/login/loginform")
	public String loginform() {
		return "login/loginform";
	}
	
	@PostMapping("/login/loginaction")
	public String login() {
		return "redirect:/";
	}
	
	@GetMapping("/login/joinform")
	public String joinform() {
		return "login/joinform";
	}
}
