<%@page import="study.dao.MyCarDao"%>
<%@page import="study.dto.MyCarDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	
	String carname = request.getParameter("carname");
	int carprice = Integer.parseInt(request.getParameter("carprice"));
	String carphoto = request.getParameter("photo");
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	
	MyCarDto dto = new MyCarDto();
	MyCarDao dao = new MyCarDao();
	
	dto.setCarname(carname);
	dto.setCarprice(carprice);
	dto.setCarphoto(carphoto);
	dto.setGuipday(year + "년 " + month + "월");
	
	dao.insertCar(dto);
	
	response.sendRedirect("mycarlist.jsp");
%>