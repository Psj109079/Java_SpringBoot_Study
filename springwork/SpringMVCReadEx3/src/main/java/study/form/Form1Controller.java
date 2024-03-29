package study.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Form1Controller {
	
	@GetMapping("/form1")
	public String form1() {
		return "myform/form1";
	}
	
	@GetMapping("/read1")
	public String read1(Model model, @RequestParam("sangpum") String sang,
			@RequestParam int price 
			/* form 의 name 과 선언한 변수명이 같을경우 앞에 name 생략가능 */, int su/* (@RequestParam 생략가능)*/  ) {
		
		model.addAttribute("sang", sang);
		model.addAttribute("price", price);
		model.addAttribute("su", su);
		return "result/readdata1";
	}
}
