<%@page import="shop.dao.BasketListDao"%>
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
	
	String[] val = request.getParameterValues("val");
	
	if(val.length == 0) {%>
	<script>
		alert("구매할 상품을 체크해주세요");
		history.back();
	</script>
<%} else {
	String[][] arr = new String[val.length][3];
	
	for(int i = 0; i < val.length; i++) {
		arr[i] = val[i].split(" ");
		
		int num = Integer.parseInt(arr[i][0]);
		String size = arr[i][1];
		int prinum = Integer.parseInt(arr[i][2]);
		
		BasketListDao Cdao = new BasketListDao();
		
		Cdao.deleteBasket(id, prinum);
	}
}

	response.sendRedirect("../basket/basketlistform.jsp");
%>