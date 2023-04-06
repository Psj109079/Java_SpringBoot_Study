package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.dao.PersonDao;
import study.dto.PersonDto;

/**
 * Servlet implementation class PersonListServlet
 */
@WebServlet("/person/list")
public class PersonListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonDao dao = new PersonDao();
		List<PersonDto> list = dao.getAllPersons();
		
		request.setAttribute("list", list);
		request.setAttribute("size", list.size());
		
		RequestDispatcher rd = request.getRequestDispatcher("../day0404_jstl/personlist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
