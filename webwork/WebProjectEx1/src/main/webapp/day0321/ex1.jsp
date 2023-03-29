<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style type="text/css">
	.hello{
		color: orange;
		font-size: 15px;
	}
</style>
</head>
<body>
	<h3 style = 'color: green;'>Hello JSP!</h3>	
	<script type = "text/javascript">
		for(let i = 1; i <= 10; i++){
			// document.write("<b class= 'hello'>" + i + "</b>&nbsp");
			document.write(`<b class= 'hello'>\${i}</b>&nbsp`);
			// literal 사용시 jsp에서는 $앞에 \를 붙여야 함(jsp에서 $의 다른기능이 정의되어있음)
		}
	</script>
	<%
		// 이곳은 자바 영역이 된다.. scriptlet 이라고 부른다
		// 이곳에서 선언하는 변수는 지역변수가 된다
		// 그래서 선언 후 그 아래쪽에서만 사용 가능하다
		String name = "홍길동";
		int year = 2010;
		
		// 브라우저로 출력 시 out 이라는 내장객체를 사용해도 된다(JspWriter)
		out.print("<h2>내 이름은 "+ name + "이고 " + year + "년생입니다</h2>");				
	%>
	<!-- 선언문의 변수나 메서드 호출은 위치가 상관없다 -->
	<%=getAddress()%><br>
	<%=address%><br>
	<%=MESSAGE%><br>
	<!--  표현식을 이용해서 자바영역의 변수 출력이 가능하다 -->
	<h2> 내 이름은 <%=name%> 이고 <%=year%>년생입니다^^</h2>
	
	<!-- 클래스 멤버벼수나 메서드를 선언하려면 선언문을 사용해야 함 -->
	<%!
		// 이곳에서 선언한 변수나 메서드는 멤버로 구현된 것이므로 위치 상관없이 어디서든 호출이 가능함
		
		final static String MESSAGE = "Bitcamp 701";
		String address = "강남구 역삼동";
		
		public String getAddress(){
			return "우리집은 " + address;
		}
	%>
</body>
</html>
