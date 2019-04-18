package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter w = res.getWriter();
		w.println("<h1>Hello, Servlet.</h1>");
		w.close();
	}

	
	
}
