<%@page import="study.dto.ShopDto"%>
<%@page import="study.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	// 데이터 읽기
	int num = Integer.parseInt(request.getParameter("num"));
	String sangpum = request.getParameter("sangpum");
	String color = request.getParameter("color");
	String photo = request.getParameter("photo");
	int su = Integer.parseInt(request.getParameter("su"));
	int dan = Integer.parseInt(request.getParameter("dan"));
	String ipgoday = request.getParameter("ipgoday");
	
	// dto에 넣기
	ShopDto dto = new ShopDto();
	dto.setNum(num);
	dto.setSangpum(sangpum);
	dto.setColor(color);
	dto.setPhoto(photo);
	dto.setSu(su);
	dto.setDan(dan);
	dto.setIpgoday(ipgoday);
	
	// insert 메소드 호출
	ShopDao dao = new ShopDao();
	dao.updateShop(dto);	
%>