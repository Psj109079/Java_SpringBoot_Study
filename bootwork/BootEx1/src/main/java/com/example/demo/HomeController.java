package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@GetMapping("/hello")
	public @ResponseBody TestDto hello() {
		TestDto dto = new TestDto();
		dto.setName("이상아");
		dto.setAddr("강남구");
		dto.setHp("010-2222-3333");
		System.out.println(dto); // toString() 호출
		return dto;
	}
}
