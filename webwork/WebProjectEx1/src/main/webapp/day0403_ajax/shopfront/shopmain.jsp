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
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	body, body * {
		font-family: 'Jua';
	}
	
	.shopadd {
		cursor: pointer;
		color: red;
		font-size: 30px;
	}
	
	.box {
		width: 40px;
		height: 30px;
		border: 1px solid black;
		margin-left: 50px;
	}
	
	.iupdate, .idelete {
		cursor: pointer;
		font-size: 30px;
	}
	
	.iupdate {
		color: green;
	}
	
	.idelete {
		color: red;
		margin-left: 30px;
	}
</style>
<script>
	$(function() {
		// 처음 시작 시 목록 출력
		list();
		// 상품 추가 모달창
		
		// 검색 후 엔터 또는 검색버튼 클릭시 list 다시 호출
		$("#btnsearch").click(function(){
			list();
		});
		
		$("#search").keyup(function(e){ // 엔터 누를때만 list함수 호출
			if(e.keyCode == 13) {
				list();			
			}
		});
		
		//$("#search").keyup(function(e){ // 키보드 누를때마다 list함수 호출
			//list();
		//});
		
		// 1. 사진 변경시 해당 사진 나오게 하기
		$("#nphoto").change(function(){
			// 선택한 사진명을 얻는다
			let imgSrc = $(this).val();
			// #photoview 의 src변경
			$("#photoview").attr("src","../../image/shop/" + imgSrc);
		});
		
		// 단가 입력 후 포커스가 벗어날때 숫자인지 아닌지 체크
		$("#ndan").blur(function(){
			if(isNaN($(this).val())) {
				alert("단가는 숫자로만 입력해주세요");
				$(this).val("");
				$(this).focus();
			}
		});
		
		// 상품 등록버튼
		$("#btnadd").click(function(){
			// 모달폼에서 입력한 값들을 읽어온다
			let sang = $("#nsangpum").val();
			let color = $("#ncolor").val();
			let photo = $("#nphoto").val();
			let su = $("#nsu").val();
			let dan = $("#ndan").val();
			let ipgoday = $("#nipgoday").val();
			
			$.ajax({
				type: "get",
				url: "../shopback/insertshop.jsp",
				data: {"sangpum" : sang, "color" : color, "su" : su, "dan" : dan, "ipgoday" : ipgoday, "photo" : photo},
				dataType: "html",
				success: function(res){
					// 현재 페이지 새로고침
					location.reload();
				}, statusCode: {
					404: function() {
						alert("파일이 없어요");
					}, 500: function() {
						alert("서버 오류... 코드를 다시한번 확인하세요");						
					}
				}
			});
		});
		
		// 수정 아이콘 클릭시 모달창에 데이터 넣기
		$(document).on("click", ".iupdate", function() { 
		// 나중에 script로 생성해준 태그이기 때문에 on 속성으로 이벤트를 줘야 정상정으로 동작함
			let num=$(this).attr("num");
			//alert(num);
			$.ajax({
				type: "get",
				url: "../shopback/selectdata.jsp",
				data: {"num" : num},
				dataType: "json",
				success: function(res){
					$("#unum").val(res.num);
					$("#usangpum").val(res.sangpum);
					$("#ucolor").val(res.color);
					$("#uphoto").val(res.photo);
					$("#usu").val(res.su);
					$("#udan").val(res.dan);
					$("#uipgoday").val(res.ipgoday);
					
					// 사진
					$("#uphotoview").attr("src", "../../image/shop/" + res.photo);
				}, statusCode: {
					404: function() {
						alert("파일이 없어요");
					}, 500: function() {
						alert("서버 오류... 코드를 다시한번 확인하세요");						
					}
				}
			});
		});
		// 수정창에서 사진변경 이벤트
		$("#uphoto").change(function(){
			// 선택한 사진명을 얻는다
			let imgSrc = $(this).val();
			// #photoview 의 src변경
			$("#uphotoview").attr("src","../../image/shop/" + imgSrc);
		});
		
		// 수정버튼 클릭시
		$("#btnupdate").click(function() {
			// form의 입력 데이터를 한꺼번에 가져온다
			// 단 form 안에서 줘야하고 태그에서는 name을 줘야한다
			let data = $("#frmupdate").serialize();
			//alert(data);
			$.ajax({
				type: "get",
				url: "../shopback/updateshop.jsp",
				data: data,
				dataType: "html",
				success: function(res){
					// 화면 새로고침
					//location.reload();
					
					list();
				}
			});
		});
		
		// 삭제 아이콘 클릭시 이벤트
		$(document).on("click", ".idelete", function() {
			// 태그에 넣어둔 num 읽기
			let num = $(this).attr("num");
			//alert(num);
			let b = confirm("삭제하려면 [확인]을 눌러주세요");
			if(b) {
				$.ajax({
					type: "get",
					url: "../shopback/deleteshop.jsp",
					data: {"num" : num},
					dataType: "html",
					success: function(res){
						list(); // 삭제 후 목록 다시 출력
					}, statusCode: {
						404: function() {
							alert("파일이 없어요");
						}, 500: function() {
							alert("서버 오류... 코드를 다시한번 확인하세요");						
						}
					}
				});
			}
		});
	});
	
	function list() {
		// search 값 읽기
		let search = $("#search").val();
		$.ajax({
			type: "get",
			url: "../shopback/listshop.jsp",
			data: {"search" : search},
			dataType: "json",
			success: function(res){
				let s = "총 " + res.length + "개의 상품이 검색되었습니다<br><br>";
				s += "<table class='table table-bordered'>";
				
				$.each(res, function(i, e){
					s += `
						<tr>
							<td width=230 align=center>
								<img src="../../image/shop/\${e.photo}" width="200" height="240" border="1">
							</td>
							<td valign=middle align=left>
								<i class="bi bi-pencil-square iupdate" num="\${e.num}" data-bs-toggle="modal" data-bs-target="#myShopUpdateModal"></i>
								<i class="bi bi-trash idelete" num="\${e.num}"></i>
								<br><br>
								상품명: \${e.sangpum}<br>
								색 상
									<div class="box" style="background-color: \${e.color}"></div>
								수량: \${e.su}개<br>
								단가: \${e.dan}원<br>
								입고일: \${e.ipgoday}
							</td>
						</tr>
					`;	
				});
				
				$(".list").html(s);				
			}, statusCode: {
				404: function() {
					alert("파일이 없어요");
				}, 500: function() {
					alert("서버 오류... 코드를 다시한번 확인하세요");						
				}
			}
		});
	}
</script>
</head>
<body>
<!-- 상품 수정 모달창 -->

<!-- The Modal -->
<div class="modal" id="myShopUpdateModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">상품 수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
      	<form id="frmupdate">
      		<input type="hidden" name="num" id="unum" value="">
			<table class="table table-bordered">
				<tr>
					<th style="background-color: #cccccc" width=80>상품명</th>
					<td>
						<input type="text"  name="sangpum" id="usangpum" class="form-control">
					</td>
				</tr>
				<tr>
					<th style="background-color: #cccccc" width=80>사진</th>
					<td class="input-group">
						<select name="photo" id="uphoto" class="form-select">
							<%
							for(int i = 1; i <= 34; i++) {
								String fname = i + "." + (i == 24? "gif" : "jpg");%>
								
								<option value="<%=fname %>"><%=fname %></option>
							<%}
							%>
						</select>
						<img src="../../image/shop/1.jpg" width="50" height="50" border="1" hspace="3" id="uphotoview">
					</td>
				</tr>
				<tr>
					<th style="background-color: #cccccc" width=80>수량</th>
					<td>
						<input type="number" name="su" id="usu" class="form-control" min="1" max="5" value="1">
					</td>
				</tr>
				<tr>
					<th style="background-color: #cccccc" width=80>단가</th>
					<td>
						<input type="text" name="dan" id="udan" class="form-control">
					</td>
				</tr>
				<tr>
					<th style="background-color: #cccccc" width=80>색상</th>
					<td>
						<input type="color" name="color" id="ucolor" class="form-control" value="#ccfdab">
					</td>
				</tr>
				<tr>
					<th style="background-color: #cccccc" width=80>입고일</th>
					<td>
						<input type="date" name="ipgoday" id="uipgoday" class="form-control">
					</td>
				</tr>
			</table>
		</form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal" id="btnupdate">상품등록</button>
      </div>

    </div>
  </div>
</div>

<!-- 상품등록 모달창 -->

<!-- The Modal -->
<div class="modal" id="myShopModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">상품 등록</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
		<table class="table table-bordered">
			<tr>
				<th style="background-color: #cccccc" width=80>상품명</th>
				<td>
					<input type="text" id="nsangpum" class="form-control">
				</td>
			</tr>
			<tr>
				<th style="background-color: #cccccc" width=80>사진</th>
				<td class="input-group">
					<select id="nphoto" class="form-select">
						<%
						for(int i = 1; i <= 34; i++) {
							String fname = i + "." + (i == 24? "gif" : "jpg");%>
							
							<option value="<%=fname %>"><%=fname %></option>
						<%}
						%>
					</select>
					<img src="../../image/shop/1.jpg" width="50" height="50" border="1" hspace="3" id="photoview">
				</td>
			</tr>
			<tr>
				<th style="background-color: #cccccc" width=80>수량</th>
				<td>
					<input type="number" id="nsu" class="form-control" min="1" max="5" value="1">
				</td>
			</tr>
			<tr>
				<th style="background-color: #cccccc" width=80>단가</th>
				<td>
					<input type="text" id="ndan" class="form-control">
				</td>
			</tr>
			<tr>
				<th style="background-color: #cccccc" width=80>색상</th>
				<td>
					<input type="color" id="ncolor" class="form-control" value="#ccfdab">
				</td>
			</tr>
			<tr>
				<th style="background-color: #cccccc" width=80>입고일</th>
				<td>
					<input type="date" id="nipgoday" class="form-control">
				</td>
			</tr>
		</table>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal" id="btnadd">상품등록</button>
      </div>

    </div>
  </div>
</div>

<div class="search input-group" style="margin: 30px 50px">
	<input type="text" id="search" placeholder="검색할 상품명을 입력하세요" style="width:200px">
	<button class="btn btn-danger btn-sm" id="btnsearch">검색</button>
	&nbsp;&nbsp;
	<i class="bi bi-plus-circle shopadd" data-bs-toggle="modal" data-bs-target="#myShopModal"></i>
</div>

<div class="list" style="margin: 20px 50px"></div>
</body>
</html>