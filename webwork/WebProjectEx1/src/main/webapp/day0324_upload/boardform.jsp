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
	body, body * {
		font-family: 'Jua';
	}
</style>
</head>
<body>
	<div style="margin: 30px 50px">
		<!-- 이미지 출력할곳 -->
    	<img id="showimg" style="position: absolute;left:500px;top:100px;max-width: 300px;">
	
		<form action="boardaction.jsp" method="post" enctype="multipart/form-data">
			<table class="table table-bordered" style="width: 400px;">
				<caption align="top"><b>게시글 쓰기</b></caption>
				<tr>
					<th style="background-color: lightgray" width="100">작성자</th>
					<td>
						<input type="text" name="writer" class="form-control" style="width:130px;"
						autofocus="autofocus" required="required">
					</td> 
				</tr>
				<tr>
					<th style="background-color: lightgray" width="100">제 목</th>
					<td>
						<input type="text" name="subject" class="form-control" required="required">
					</td> 
				</tr>
				<tr>
					<th style="background-color: lightgray" width="100">사진(1장)</th>
					<td>
						<input type="file" name="upload" class="form-control" id="myfile">
					</td> 
				</tr>
				<tr>
					<td colspan="2">
						<textarea style="width: 100%; height: 150px;" name="content" required="required"></textarea>
					</td> 
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-secondary btn-sm">게시글저장</button>
						<button type="button" class="btn btn-secondary btn-sm" onclick="history.back()">이전으로</button>
					</td> 
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">

		$("#myfile").change(function(){
		  	console.log("1:"+$(this)[0].files.length);
		  	console.log("2:"+$(this)[0].files[0]);
	
	  		//정규표현식
			var reg = /(.*?)\/(jpg|jpeg|png|bmp)$/;
			var f=$(this)[0].files[0];//현재 선택한 파일
	
			if(!f.type.match(reg)){
		   		alert("확장자가 이미지파일이 아닙니다");
		   		return;
			}
	
		  	if($(this)[0].files[0]){
		   		var reader=new FileReader();
		   		reader.onload=function(e){
		    		$("#showimg").attr("src",e.target.result);
		   		}
	   			reader.readAsDataURL($(this)[0].files[0]);
	  		}
	 	});
	</script>
</body>
</html>