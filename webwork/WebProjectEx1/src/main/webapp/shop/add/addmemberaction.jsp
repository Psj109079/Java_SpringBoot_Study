<%@page import="shop.dto.MemberDto"%>
<%@page import="shop.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String address = request.getParameter("address") + " " + request.getParameter("detailaddress");
	
	MemberDao dao = new MemberDao();
	MemberDto dto = new MemberDto();
	
	boolean duplicate = dao.duplicate(id);
	
	if(duplicate) { %>
		<script>
			alert("중복된 아이디입니다");
			history.back();
		</script>
	<%} else {
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setAddress(address);
		
		dao.join(dto);
		
		response.sendRedirect("../main.jsp");
	}
%>