<%@page import="shop.dao.BasketListDao"%>
<%@page import="shop.dao.BuyListDao"%>
<%@page import="shop.dto.MemberDto"%>
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

	String renameId = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String address = request.getParameter("address") + " " + request.getParameter("detailaddress");
	
	MemberDao Mdao = new MemberDao();
	MemberDto Mdto = new MemberDto();
	BuyListDao Bdao = new BuyListDao();
	BasketListDao Cdao = new BasketListDao();
	
	boolean duplicate = Mdao.duplicate(renameId);

	if(id.equals(renameId)) {
		duplicate = false;
	}
	
	if(duplicate) { %>
		<script>
			alert("중복된 아이디입니다");
			history.back();
		</script>
	<%} else {
		Mdto.setId(id);
		Mdto.setPw(pw);
		Mdto.setName(name);
		Mdto.setAddress(address);
		
		Bdao.updateIdBuy(renameId, id);
		Cdao.updateIdBasket(renameId, id);
		Mdao.updateMember(Mdto, renameId);
		
		response.sendRedirect("../login&logout/logoutaction.jsp");
	}
%>