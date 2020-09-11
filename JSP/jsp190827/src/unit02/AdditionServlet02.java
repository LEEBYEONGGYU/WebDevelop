package unit02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdditionServlet02
 */
@WebServlet("/AdditionServlet02")
public class AdditionServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditionServlet02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = 20;
		int num2 = 10;
		int sum = num1+num2;
		
		request.setAttribute("num1", num1);
		request.setAttribute("num2", num2);
		request.setAttribute("sum", sum);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("addition03.jsp");
		dispatcher.forward(request, response);
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println(num1+"+"+num2+"="+sum);
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
