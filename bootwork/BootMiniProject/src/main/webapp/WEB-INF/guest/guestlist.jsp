<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<%@ include file="../commonvar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Single+Day&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	body, body *{
		font-family: 'Jua'
	}
	
	.small_photo {
		border: 5px solid pink;
		border-radius: 30px;
		margin-rigth: 10px;
	}
	
	.today {
		float: right;
		color: #cccccc;
		font-size: 14px;
		margin-right: 10px;
	}
	
	div.guest_box {
		width: 500px;
		height: 200px;
		border: 1px solid gray;
		margin-bottom: 20px;
		padding: 10px 20px;
		margin-left: 100px;
	}
	div.guest_box>div {
		margin-bottom: 10px;
	}
	
	.photodel {
		cursor: pointer;
		font-size: 1.2em;
		position: relative;
		left: -20px;
		top: -30px;
		visibility: hidden;
	}
</style>
<script type="text/javascript">
	$(function() {
		list();
		
		// 사진부터 업로드
	/* 	$("#photoupload").change(function() {
			// input type file 은 한개더라도 배열타입으로 넘어옴
			let cnt = $(this)[0].files.length;
			if(cnt > 3) {
				alert("3장까지만 업로드 가능합니다");
				$("#photoupload").val("");
				return false;
			}
			var form = new FormData();
			for(i = 0; i < $(this)[0].files.length; i++) {
				form.append("upload", $(this)[0].files[i]); // 선택한 사진 모두 추가
			}
			
			$.ajax({
				type: "post",
				dataType: "text",
				url: "upload",
				processData: false,
				contentType: false,
				data: form,
				success: function(res) {
					
				}
			});
		}); */
		
	/* 	$("#guestadd").click(function() {
			let content = $("#content").val();
			let nn = $("#nickname").val();
			console.log(content);
			$.ajax({
				type: "post",
				dataType: "text",
				url: "./insert",
				data: {"content":content, "nickname": nn},
				success: function(res) {
					// 입력값 초기화
					$("#nickname").val("");
					$("#content").val("");
					$("#photoupload").val("");
					// 목록 다시 호출
					list();
				}
			});
		}); */
		
		// 업로드한 사진들과 데이터를 같이 묶어서 서버에 전송하기
		$("#guestadd").click(function() {
			let cnt = $("#photoupload")[0].files.length;
			let content = $("#content").val();
			let nn = $("#nickname").val();
			
			if(content.length == 0) {
				alert("내용을 입력해주세요");
				return false;
			}
			if(nn.length == 0) {
				alert("닉네임을 입력해주세요");
				return false;
			}
			var form = new FormData();
			for(i = 0; i < $("#photoupload")[0].files.length; i++) {
				form.append("upload", $("#photoupload")[0].files[i]); // 선택한 사진 모두 추가
			}
			form.append("content", content);
			form.append("nickname", nn);
			$.ajax({
				type: "post",
				dataType: "text",
				url: "./insert",
				processData: false,
				contentType: false,
				data: form,
				success: function(res) {
					// 입력값 초기화
					$("#nickname").val("");
					$("#content").val("");
					$("#photoupload").val("");
					// 목록 다시 호출
					list();
				}
			});
		});
		
		// 이미지 이벤트
		$(document).on("mouseover", ".photo_box img",function(){
			$(this).next().css("visibility", "visible");
		});
		
		$(document).on("mouseout", ".photo_box img",function(){
			$(this).next().css("visibility", "hidden");
		});
		
		$(document).on("mouseover", ".photodel",function(){
			$(this).css("visibility", "visible");
		});
		
		$(document).on("mouseout", ".photodel",function(){
			$(this).css("visibility", "hidden");
		});
		
		// x아이콘 이벤트
		$(document).on("click", ".photodel",function(e){
			//e.stopPropagation();
			
			let c = confirm("해당 사진을 삭제하시겠습니까");
			if(c) {
				let photo_idx = $(this).attr("photo_idx");
				
				$.ajax({
					type: "get",
					url: "./deletephoto",
					data: {"photo_idx":photo_idx},
					dataType: "text",
					success: function() {
						alert("삭제되었습니다");
						// 목록 다시 호출
						list();
					}
				});
			}
		});
		
		// 방명록 삭제 이벤트
		$(document).on("click", ".guestdel",function(e){
			
			let c = confirm("해당 방명록을 삭제하시겠습니까");
			if(c) {
				let guest_idx = $(this).attr("guest_idx");
				
				$.ajax({
					type: "get",
					url: "./delete",
					data: {"guest_idx":guest_idx},
					dataType: "text",
					success: function() {
						alert("삭제되었습니다");
						// 목록 다시 호출
						list();
					}
				});
			}
		});
	});
	
	
	function large_photo(photoname) {
		let src=`https://${imageUrl}/guest/\${photoname}`;
		// alert(src);
		$("#view").attr("src", src);
	}
	
	function list() {
		$.ajax({
			type: "get",
			url: "./alist",
			dataType: "json",
			success: function(res) {
				let s = "";
				$.each(res, function(idx, ele) {
					s += `
						<div class="guest_box">
							<div>
								<b>\${ele.nickname}</b>
								<span class="today">\${ele.writeday}</span>
								&nbsp;
								<i class="bi bi-trash guestdel" guest_idx = "\${ele.guest_idx}"
								style="cursor:pointer"></i>
							</div>
							<pre>\${ele.content}</pre>
						`;
					// 각 방명록에 추가한 이미지 출력
					s += "<div class='photo_box'>";
					$.each(ele.photoList, function(pidx, pele) {
						s += `
							<img src="http://${imageUrl_small}/guest/\${pele.photoname}?type=f&w=80&h=80&faceopt=true&ttype=jpg"
								class="small_photo" onclick="large_photo('\${pele.photoname}')" data-bs-toggle="modal" data-bs-target="#myImgModal">
							<i class="bi bi-x-square photodel" photo_idx="\${pele.photo_idx}"></i>
						`;
					});
					s += "</div></div>";
				
				});
				$("div.alist").html(s);
			}
		});
	}
</script>
</head>
<body>
	<div style="width: 500px; margin-left: 100px;">
		<input type="text" id="nickname" class="form-control" placeholder="닉네임" style="width: 130px;">
		
		<textarea style="width: 80%; height: 100px" class="form-control" id="content"></textarea>
		<input type="file" id="photoupload" multiple="multiple">
		<button type="button" class="btn btn-sm btn-outline-success" id="guestadd">등록</button>
	</div>
	<hr>
	<div class="alist"></div>
	
	<!-- The Modal -->
<div class="modal" id="myImgModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">이미지</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <img src="" id="view" style="max-width: 100%;">
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
</body>
</html>
