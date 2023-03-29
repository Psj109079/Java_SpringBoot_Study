<%@page import="shop.dao.BuyListDao"%>
<%@page import="shop.dao.WareDao"%>
<%@page import="shop.dto.WareDto"%>
<%@page import="shop.dao.BasketListDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
	Cookie[] cookies = request.getCookies();

	String id = "";
	for(Cookie c : cookies) {
		if(c.getName().equals("user") || c.getName().equals("admin")) {
			id = c.getValue();	
			break;
		}
	}
	int num = Integer.parseInt(request.getParameter("num"));
	String size = request.getParameter("size");	
	
	WareDao dao = new WareDao();
	
	WareDto dto = dao.wareDetail(num);
	
	BuyListDao Bdao = new BuyListDao();;
	
	Bdao.saveBuyList(id, size, dto);
	
	response.sendRedirect("../main.jsp");
	
%>