package com.toy.restaurant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import rs.dao.MemberDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {	
	@Autowired
	private MemberDao memberDao;

	@GetMapping(value = "/")
	public String home(Model model) {
		
		model.addAttribute("count", memberDao.totalCount());
		
		return "/views/main";
	}
	
}
