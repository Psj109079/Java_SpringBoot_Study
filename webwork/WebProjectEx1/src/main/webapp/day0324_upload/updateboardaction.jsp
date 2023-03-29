<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="study.dao.SimpleBoardDao"%>
<%@page import="study.dto.SimpleBoardDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<%	
	MultipartRequest mulRequest = null;
	// 저장할 경로
	ServletContext context = getServletContext();
	String realPath = context.getRealPath("/save");
	
	System.out.println(realPath);
	
	// 업로드할 사진 사이즈
	int uploadSize = 1024 * 1024 * 3; // 3MB
	
	try {
		mulRequest = new MultipartRequest(request, realPath, uploadSize, "utf-8",
				new DefaultFileRenamePolicy());
		// 데이터 읽기
		int num = Integer.parseInt(mulRequest.getParameter("num"));
		String writer = mulRequest.getParameter("writer");
		String subject = mulRequest.getParameter("subject");
		String content = mulRequest.getParameter("content");
		String photo = mulRequest.getFilesystemName("upload"); // 실제 업로드된 파일명
		
		// dto에 담기
		SimpleBoardDto dto = new SimpleBoardDto(writer, subject, content, photo);
		dto.setNum(num);
		
		// dao 선언
		SimpleBoardDao dao = new SimpleBoardDao();
		// update
		dao.updateBoard(dto);
		
		// 목록으로 이동	
		response.sendRedirect("detailboard.jsp?num=" + num);
	} catch(Exception e){
		out.print("업로드 수정하다가 오류났어요: " + e.getMessage());
	}
%>