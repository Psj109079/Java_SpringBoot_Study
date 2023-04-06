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
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	
	SmartDao dao = new SmartDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// num 읽기
		int n = Integer.parseInt(request.getParameter("num"));
		
		// 조회수 증가
		dao.updateReadCount(n);
		
		// dto 얻기
		SmartDto dto = dao.getData(n);
		
		// request에 dto 저장
		request.setAttribute("detail", dto);
			
		RequestDispatcher rd = request.getRequestDispatcher("../day0405_smart/detail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
