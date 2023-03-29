<%@page import="study.dao.PersonDao"%>
<%@page import="study.dto.PersonDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <%
	request.setCharacterEncoding("utf-8");
%>
<!-- jsp 의 자바빈즈 기능 -->
<!-- dao 선언 -->
<jsp:useBean id="dao" class="study.dao.PersonDao"/>
<jsp:useBean id="dto" class="study.dto.PersonDto"></jsp:useBean>
<!-- form태그의 name과 같은 경우에만 dto 에 자동주입 -->
<jsp:setProperty property="*" name="dto"/>
<%
	//수정 메서드 호출
	dao.updatePerson(dto);
	//목록으로 이동
	response.sendRedirect("personlist.jsp");

%> --%>

<%
	//엔코딩
	request.setCharacterEncoding("utf-8");
	//데이타 각각 읽기
	int num=Integer.parseInt(request.getParameter("num"));
	String name=request.getParameter("name");
	int birthyear=Integer.parseInt(request.getParameter("birthyear").trim());
	String address=request.getParameter("address");
	
	String job=request.getParameter("job");
	String photo=request.getParameter("photo");
	
	//dto선언
	PersonDto dto=new PersonDto();
	//데이타 dto에 넣기
	dto.setNum(num);
	dto.setName(name);
	dto.setAdress(address);
	dto.setBirthyear(birthyear);
	dto.setPhoto(photo);
	dto.setJob(job);
	
	//dao선언
	PersonDao dao=new PersonDao();
	
	//update 메서드 호출
	dao.updatePerson(dto);
	//페이지 이동
	response.sendRedirect("personlist.jsp");	

%>