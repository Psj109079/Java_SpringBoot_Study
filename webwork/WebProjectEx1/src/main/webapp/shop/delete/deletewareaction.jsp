<%@page import="shop.dao.BasketListDao"%>
<%@page import="shop.dao.BuyListDao"%>
<%@page import="shop.dao.WareDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	
	WareDao Wdao = new WareDao();
	BuyListDao Bdao = new BuyListDao();
	BasketListDao Cdao = new BasketListDao();
	
	Cdao.deleteBasketlist(num);
	Bdao.deleteBuylist(num);
	Wdao.deleteWare(num);
	
	response.sendRedirect("../main.jsp");
%>