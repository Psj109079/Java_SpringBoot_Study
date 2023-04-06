<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
 <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
	body, body *{
		font-family: 'Jua'
	}
</style>
</head>
<body>
<h4 class="alert alert-info" style="width: 400px">post 방식의 폼태그 전송</h4>
<form action="action2.jsp" method="post">
    <!-- hidden -->
    <input type="hidden" name="message" value="Happy Day!">
	<table class="table table-bordered" style="width: 400px">
		<tr>
			<th bgcolor="lightgray" width="100">상품명</th>
			<td>
				<input type="text" name="sang" required="required"
				class="form-control" placeholder="상품명입력">
			</td>
		</tr>
		<tr>
			<th bgcolor="lightgray" width="100">비밀번호</th>
			<td>
				<input type="password" name="pass" required="required"
				class="form-control" placeholder="비밀번호"
				pattern="[0-9]{4}">
			</td>
		</tr>
		<tr>
			<th bgcolor="lightgray" width="100">색상들</th>
			<td>
				<div class="input-group">
					<input type="checkbox" class="form-check-input"
					name="color" value="pink">핑크&nbsp;
					<input type="checkbox" class="form-check-input"
					name="color" value="green">초록&nbsp;
					<input type="checkbox" class="form-check-input"
					name="color" value="orange">오렌지&nbsp;
					<input type="checkbox" class="form-check-input"
					name="color" value="blue">파랑					
				</div>
			</td>
		</tr>
		<tr>
			<th bgcolor="lightgray" width="100">사 진</th>
			<td>
				<select class="form-select" style="width: 200px"
				name="photo">
					<option value="27.jpg">투피스</option>
					<option value="28.jpg">원피스</option>
					<option value="15.jpg">신발</option>
					<option value="23.jpg">모자</option>					
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" class="btn btn-success">서버에 전송</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>

























