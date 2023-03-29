<%@page import="study.dao.PersonDao"%>
<%@page import="study.dto.PersonDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
	// 인코딩
	request.setCharacterEncoding("utf-8");

	// 데이터 각각 읽기
	String name = request.getParameter("name");
	int birthYear = Integer.parseInt(request.getParameter("birthyear"));
	String address = request.getParameter("address");
	String job = request.getParameter("job");
	String photo = request.getParameter("photo");
	
	// dto 선언
	PersonDto dto = new PersonDto();
	
	// 데이터 dto에 넣기
	dto.setName(name);
	dto.setBirthyear(birthYear);
	dto.setAdress(address);
	dto.setJob(job);
	dto.setPhoto(photo);
	
	// dao 선언
	PersonDao dao = new PersonDao();
	
	// insert 메서드 호출
	dao.insertPerson(dto);
	
	// 페이지 이동
	response.sendRedirect("personlist.jsp");

%>