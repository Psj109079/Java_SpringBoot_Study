<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="study.dto.MyCarDto"%>
<%@page import="java.util.List"%>
<%@page import="study.dao.MyCarDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	MyCarDao dao = new MyCarDao();
	List<MyCarDto> list = dao.getAllCars();
	
	JSONArray arr = new JSONArray();
	
	for(MyCarDto dto : list) {
		JSONObject ob = new JSONObject();
		ob.put("num", dto.getNum());
		ob.put("carname", dto.getCarname());
		ob.put("carprice", dto.getCarprice());
		ob.put("carphoto", dto.getCarphoto());
		ob.put("guipday", dto.getGuipday());
		
		// array 에 object 를 추가한다
		arr.add(ob);
	}
%>
<%=arr.toString()%>