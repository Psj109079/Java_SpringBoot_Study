<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	//체크값
	String chksave=request.getParameter("chksave");
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	
	//out.println("chksave="+chksave);//체크안하면 null 체크하면on
	
	//비밀번호가 맞으면 세션에 3가지를 저장
	if(pass.equals("1234")){
		session.setMaxInactiveInterval(60*60);//유지시간 1시간
		session.setAttribute("loginid", id);
		session.setAttribute("chksave", chksave==null?"no":"yes");//체크하면 yes,안하면 no가저장
		session.setAttribute("loginstate", "yes");
		
		//successpage 로 이동
		response.sendRedirect("successpage.jsp");		
	}else{%>
		<script>
			alert("비밀번호가 맞지 않습니다");
			history.back();
		</script>		
	<%}
	
%>