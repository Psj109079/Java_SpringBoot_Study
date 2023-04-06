<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="study.dto.SawonDto"%>
<%@page import="java.util.List"%>
<%@page import="study.dao.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	int gender = Integer.parseInt(request.getParameter("gender"));
	
	SawonDao dao = new SawonDao();
	List<SawonDto> list = dao.selectAll(gender);
	
	JSONArray ja = new JSONArray();
	
	for(SawonDto dto : list) {
		JSONObject oj = new JSONObject();
		oj.put("num", dto.getNum());
		oj.put("name", dto.getName());
		oj.put("score", dto.getScore());
		oj.put("gender", dto.getGender());
		oj.put("buseo", dto.getBuseo());
		
		ja.add(oj);
	}
%>
<%=ja.toString()%>
