package smart.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.dao.SmartDao;
import study.dto.SmartDto;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 인코딩
		request.setCharacterEncoding("utf-8");
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		// dto
		SmartDto dto = new SmartDto();
		dto.setWriter(writer);
		dto.setSubject(subject);
		dto.setContent(content);
		
		// dao
		SmartDao dao = new SmartDao();
		// insert
		dao.insertSmart(dto);
		
		response.sendRedirect("list"); // 데이터 db에 추가 후 목록으로 이동
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
