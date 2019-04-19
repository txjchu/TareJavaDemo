package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * °¸ÀýCookie
 * @author Administrator
 *
 */
public class CookieServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		Cookie c1 = new Cookie("pp","sx");
		Cookie c2 = new Cookie("city", "xa");
		
		res.addCookie(c1);
		res.addCookie(c2);
		out.println("<h1>CookieÁ·Ï°</h1>");
		
		out.close();
		
	}
	
}










