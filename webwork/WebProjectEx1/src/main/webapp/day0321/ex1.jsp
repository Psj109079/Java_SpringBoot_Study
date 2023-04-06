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
  <h3 style="color: green;">Hello JSP!!</h3>
  <script type="text/javascript">
  	for(let i=1;i<=10;i++){
  		//document.write("<b class='hello'>"+i+"</b>&nbsp;");
  		
  		//jsp 에서는 es6 literal 사용시 변수값 가져오는 $ 앞에 \ 붙인다
  		//왜냐하면 jsp 에서 $ 의 다른기능이 이미 있음
  		document.write(`<b class='hello'>\${i}</b>&nbsp;`);
  	}
  </script>
  
  <%
  	//이곳은 자바 영역이 된다..scriptlet 이라고 부른다
  	//이곳에서 선언하는 변수는 지역변수가 된다
  	//그래서 선언후 그 아래쪽에서만 사용 가능하다
  	String name="홍길동";
  	int year=2010;
  	
  	//브라우저로 출력시 out 이라는 내장객체를 사용해도 된다(JspWriter)
  	out.print("<h2>내 이름은 "+name+" 이고 "+year+"년생입니다</h2>");  	
  %>
  <!-- 선언문의 변수나 메서드 호출은 위치가 상관없다 -->
  <%=getAssress()%><br>
  <%=address%><br>
  <%=MESSAGE%><BR>
  
  <%-- 표현식을 이용해서 자바영역의 변수 출력이 가능하다 --%>
  <h2>내 이름은 <%=name%> 이고 <%=year%>년생입니다 ^^</h2>
  
  <!-- 클래스 멤버변수나 메서드를 선언하려면 선언문을 사용하여야 한다 -->
  <%!
      //이곳에서 선언한 변수나 메서드는 멤버로 구현된것이므로 
      // 위치 상관없이 어디서든 호출이 가능하다
      final static String MESSAGE="Bitcamp 701";
      String address="강남구 역삼동";
      
      public String getAssress()
      {
    	  return "우리집은 "+address;
      }
  %>
</body>
</html>


















