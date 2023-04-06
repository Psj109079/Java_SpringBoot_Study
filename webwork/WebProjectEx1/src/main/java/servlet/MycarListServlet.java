package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.dao.MyCarDao;
import study.dto.MyCarDto;

/**
 * Servlet implementation class MycarListServlet
 */
@WebServlet("/mycar/list")
public class MycarListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MyCarDao dao = new MyCarDao();
		List<MyCarDto> list = dao.getAllCars();
		
		request.setAttribute("data", list);
		request.setAttribute("size", list.size());
		
		RequestDispatcher rd = request.getRequestDispatcher("../day0404_jstl/mycarlist.jsp");
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
