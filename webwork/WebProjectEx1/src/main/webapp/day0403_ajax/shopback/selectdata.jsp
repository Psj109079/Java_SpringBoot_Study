<%@page import="org.json.simple.JSONObject"%>
<%@page import="study.dto.ShopDto"%>
<%@page import="study.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));

	ShopDao dao = new ShopDao();
	
	ShopDto dto = dao.getSangpum(num);
	JSONObject ob = new JSONObject();
	
	ob.put("num", dto.getNum());
	ob.put("sangpum", dto.getSangpum());
	ob.put("color", dto.getColor());
	ob.put("photo", dto.getPhoto());
	ob.put("su", dto.getSu());
	ob.put("dan", dto.getDan());
	ob.put("ipgoday", dto.getIpgoday());
%>

<%=ob.toString()%>