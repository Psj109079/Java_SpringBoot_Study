<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="study.dto.SawonDto"%>
<%@page import="java.util.List"%>
<%@page import="study.dao.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	int select = Integer.parseInt(request.getParameter("select"));

	// dao 선언
	SawonDao dao = new SawonDao();
	
	// select 에 맞게 데이터 가져오기
	List<SawonDto> list = dao.selectAll(select);
	
	JSONArray arr = new JSONArray();
	
	for(SawonDto dto : list) {
		JSONObject ob = new JSONObject();
		
		ob.put("num", dto.getNum());
		ob.put("name", dto.getName());
		ob.put("gender", dto.getGender());
		ob.put("buseo", dto.getBuseo());
		ob.put("score", dto.getScore());
		
		// arr에 추가
		arr.add(ob);
	}
%>

<%=arr.toString()%>