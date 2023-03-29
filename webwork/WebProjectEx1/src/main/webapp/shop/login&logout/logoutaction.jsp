<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%

	Cookie[] cookies = request.getCookies();
	
	for(Cookie c : cookies) {
		if(c.getName().equals("user") || c.getName().equals("admin")) {
			c.setMaxAge(0);
			c.setPath("/");
			response.addCookie(c);
		}
	}
	
	response.sendRedirect("../main.jsp");
%>
