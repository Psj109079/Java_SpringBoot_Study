<%@page import="study.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));

	ShopDao dao = new ShopDao();
	
	dao.deleteShop(num);

%>