package study.okky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AController {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
}
