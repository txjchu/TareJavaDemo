package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, 
							HttpServletResponse arg1)
			throws ServletException, IOException {
			arg1.setContentType("text/html");//----设置文本类型
			PrintWriter w = arg1.getWriter();
			w.println("<h1>Hi,Servlet!<h1>");
			w.close();
			

			
	}

}
