package okky.mini.main;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	List<ShopDto> list = new Vector<>();
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "Happy Day!!!");
		
		ShopDto dto = ShopDto.builder()
				.sang("복숭아")
				.su(5)
				.dan(1200)
				.build();
		model.addAttribute("dto", dto);
		model.addAttribute("today", new Date());
		return "home";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		list.clear();
		list.add(new ShopDto("1", "1.jpg", 6, 1100));
		list.add(new ShopDto("2", "2.jpg", 5, 2200));
		list.add(new ShopDto("3", "3.jpg", 4, 3300));
		list.add(new ShopDto("4", "4.jpg", 3, 4400));
		list.add(new ShopDto("5", "5.jpg", 2, 5500));
		list.add(new ShopDto("6", "6.jpg", 1, 6600));
		
		model.addAttribute("list", list);
 		return "list";
	}
	
	@GetMapping("detail")
	public String detail(int index, Model model, HttpSession session) {
		session.setAttribute("loginid", "admin");
	
		model.addAttribute("dto", list.get(index));
		return "detail";
	}
}
