package smart.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.dao.SmartDao;
import study.dto.SmartDto;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// 데이터 읽어서 dto에 넣기
		int num = Integer.parseInt(request.getParameter("num"));
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		SmartDto dto = new SmartDto();
		
		dto.setNum(num);
		dto.setWriter(writer);
		dto.setSubject(subject);
		dto.setContent(content);
		
		// 수정 메소드 호출
		SmartDao dao = new SmartDao();
		
		dao.updateSmart(dto);
		
		// 수정 후 상세페이지로 이동
		response.sendRedirect("detail?num=" + num);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
