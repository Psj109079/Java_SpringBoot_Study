package smart.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.dao.SmartDao;
import study.dto.SmartDto;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	SmartDao dao = new SmartDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 총 갯수를 구한다
		int totalCount = dao.getTotalCount();
		
		// 전체 목록 가져오기
		List<SmartDto> list = dao.getAllList();
		
		// request에 저장
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/day0405_smart/list.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

