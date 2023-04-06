package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.dao.ShopDao;
import study.dto.ShopDto;


@WebServlet("/shop/list")
public class ShopListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShopDao dao = new ShopDao();
		List<ShopDto> list = dao.getSangpumList("");
		// request에 모든 출력정보 저장
		request.setAttribute("list", list);
		request.setAttribute("count", list.size());
		
		RequestDispatcher rd = request.getRequestDispatcher("../day0404_jstl/shoplist.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
