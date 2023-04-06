package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/bit/hello.do") // 매핑주소는 임의대로 줘도 된다
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		PrintWriter out = response.getWriter();
//		out.append("<h1 style='color:green;'>Servlet Exe</h1>");
		
		String msg = "행복하세요";
		Date date = new Date();
		
		// request에 저장
		request.setAttribute("msg", msg);
		request.setAttribute("today", date);
		
		
		// 출력할 jsp로 포워드
		// forward: url주소 안바뀜, request의 값을 그대로 전달
		// redirect: url주소 바뀜, request 의 값 전달 안됨(이유 = request가 새로 생성되므로)
		
		RequestDispatcher rd = request.getRequestDispatcher("../day0404_jstl/go.jsp");
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
