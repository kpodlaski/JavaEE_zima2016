package myservlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/image")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String queryString = request.getQueryString();
		if (queryString == null) queryString="a=b";
		String[] elements = queryString.split("&");
		String id="1"; String type ="jpg";
		for (String elem : elements){
			String[] kV = elem.split("=");
			if (kV[0].equals("type")) {
				type = kV[1];
			}
			if (kV[0].equals("id")){
				id = kV[1];
			}
		}
		response.setHeader("Content-Type", "image/"+type);
		File file = new File("D:\\Temp\\"+id+"."+type);
		InputStream in = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		int c;
		while( (c = in.read() ) >-1 ){
			out.write(c);
		}
		out.close();
		in.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
