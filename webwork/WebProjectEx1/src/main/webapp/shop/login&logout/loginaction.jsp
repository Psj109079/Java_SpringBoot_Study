<%@page import="java.util.List"%>
<%@page import="shop.dto.MemberDto"%>
<%@page import="shop.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDao dao = new MemberDao();
	List<MemberDto> list = dao.getAllData();
	boolean b = false;
	Exit :
	for(int i = 0; i < list.size(); i++) {
		if(list.get(i).getId().equals(id) && list.get(i).getPw().equals(pw)) {
			Cookie cookie = null;
			String name = "";
			String val = "";
			
			if(id.equals("admin")){
				cookie = new Cookie("admin", id);
				cookie.setPath("/");//쿠키저장위치를 루트(/) 로 설정
				cookie.setMaxAge(60*60);//1시간 설정
				response.addCookie(cookie);//브라우저에 쿠키 추가
				name = cookie.getName();
				val = cookie.getValue();
				b = true;
				break Exit;
			} else {
				cookie = new Cookie("user", id);
				cookie.setPath("/");//쿠키저장위치를 루트(/) 로 설정
				cookie.setMaxAge(60*60);//1시간 설정
				response.addCookie(cookie);//브라우저에 쿠키 추가
				name = cookie.getName();
				val = cookie.getValue();
				b = true;
				break Exit;
			}
		}
	}
	
	if(b) {
		response.sendRedirect("../main.jsp");	
	} else if (b == false) {%>
<script>
	alert("아이디나 비밀번호를 확인해주세요");
	history.back();
</script>
<%}%>