package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet({ "/MyServlet", "/MyServlet.html", "/MyServlet.php" })
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Content-Type: text/html; charset=utf-8
		response.setHeader("Content-Type", "text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("<html><head></head><body>");
		out.append("Served at: ").append(request.getContextPath());
		out.append("<br/>");
		String header;
		Enumeration<String> headerNames = request.getHeaderNames();
		while ( headerNames.hasMoreElements()){
			header = headerNames.nextElement();
			out.write(header);
			out.write("::");
			out.write(request.getHeader(header));
			out.write("<hr/><br/>");		
		}
		out.write("a¹Ÿ¿æœó³");
		out.write("</body></html>");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
