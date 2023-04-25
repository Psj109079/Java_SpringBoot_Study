package com.toy.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import rs.dao.MemberDao;

@Controller
public class MemberController {
	
	@Autowired
	MemberDao memberDao;
	
	public String addMember() {
		
	}
}
