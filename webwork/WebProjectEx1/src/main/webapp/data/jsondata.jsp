<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
	String sang = "원피스";
	int su = 2;
	int dan = 23000;
	
	String s = "";
	
	s += "{";
	s += "\"sang\":\"" + sang + "\",";
	s += "\"su\":" + su + ",";
	s += "\"dan\":" + dan;
	s += "}";
%>

<%=s%>