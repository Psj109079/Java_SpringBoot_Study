<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap" rel="stylesheet">
<style type="text/css">
	body, body *{
		font-family: 'Jua'
	}
	
	.tab1{
		border-collapse: collapse;
		border:3px inset gray;
	}
	
	.tab1 th, .tab1 td{
		border: 1px solid gray;
	}
</style>
</head>
<body>
<h2>구구단</h2>
<table style="width: 100%;" class="tab1">
  <tr bgcolor="orange">
  <%
  	for(int dan=2;dan<=9;dan++){%>
  		<th><%=dan%>단</th>
  	<%}
  %>
  </tr>
  <%
  for(int i=1;i<=9;i++)
  {%>
	  <tr>
	 <% for(int dan=2;dan<=9;dan++)
	  {%>
		<td align="center"><%=dan%>x<%=i%>=<%=dan*i%></td>  
	  <%}%>
	</tr>  
  <%}
  %>
</table>

</body>
</html>

















