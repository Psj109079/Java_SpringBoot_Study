<%@page import="shop.dao.WareDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="shop.dto.WareDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	MultipartRequest mulRequest = null;
	
	// 저장할 경로
	ServletContext context = getServletContext();
	String realPath = context.getRealPath("/save");
	
	System.out.println(realPath);
	
	int uploadSize = 1024 * 1024 * 6; 
	
	try {
		mulRequest = new MultipartRequest(request, realPath, uploadSize, "utf-8",
				new DefaultFileRenamePolicy());
		// 데이터 읽기
		String type = mulRequest.getParameter("type");
		String name = mulRequest.getParameter("name");
		String size = mulRequest.getParameter("size");
		String image = mulRequest.getFilesystemName("image");
		int price = Integer.parseInt(mulRequest.getParameter("price"));
		
		// dto 담기
		WareDto dto = new WareDto();
		dto.setType(type);
		dto.setName(name);
		dto.setSize(size);
		dto.setImage(image);
		dto.setPrice(price);
		
		// dao 선언
		WareDao dao = new WareDao();
		
		// insert 
		dao.insertWare(dto);
		
		// 목록으로 이동
		response.sendRedirect("../main.jsp");
		
	} catch(Exception e){
		out.print("업로드하다가 오류났어요: " + e.getMessage());
	}
%>