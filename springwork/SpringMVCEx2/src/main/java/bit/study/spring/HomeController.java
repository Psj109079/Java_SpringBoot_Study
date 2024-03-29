package bit.study.spring;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// 자동으로 xml에 bean을 등록
@Controller
public class HomeController {
	
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	//@RequestMapping(value = "/") <- get일때만 이런식으로 생략이 가능
	
	@GetMapping("/") // 5.0 부터 가능
	public String home(Model model, HttpSession session) {
		//session 에 저장
		session.setAttribute("myid", "angel");
		// request 에 저장
		model.addAttribute("message", "Have a Good Day!!!");
		model.addAttribute("today", new Date());
		return "home"; // 포워드할 파일명 /WEB-INF/views/home.jsp
	}
	
//	@GetMapping("/myshop")
	@GetMapping({"/myshop", "/yourshop"})
	public ModelAndView goShop() {
		ModelAndView model = new ModelAndView();
		model.addObject("sangpum", "폭스바겐");
		model.addObject("price", "5천만원");
		model.addObject("color", "yellow");
		model.addObject("carname", "mycar1.png");
		// 포워드
		model.setViewName("myshop");
		return model;
		
	}
}
