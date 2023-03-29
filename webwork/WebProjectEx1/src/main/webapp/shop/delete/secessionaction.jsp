<%@page import="shop.dao.BasketListDao"%>
<%@page import="shop.dao.BuyListDao"%>
<%@page import="shop.dao.MemberDao"%>
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
	
	MemberDao Mdao = new MemberDao();
	BuyListDao Bdao = new BuyListDao();
	BasketListDao Cdao = new BasketListDao();
	
	Bdao.deleteBuylist(id);
	Cdao.deleteBasketlist(id);
	Mdao.secessionMember(id);
	
	
	response.sendRedirect("../login&logout/logoutaction.jsp");
%>