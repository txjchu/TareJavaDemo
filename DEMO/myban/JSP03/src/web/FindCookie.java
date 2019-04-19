package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 案例查询cookie
 * @author Administrator
 *
 */
public class FindCookie extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(Cookie c : cookies){
				String name = c.getName();
				String value = c.getValue();
				out.println("name:"+ name +","+ "value:" +value);
			}
		} else {
			out.print("没有找到cookie");
		}
		out.close();
		
		
	}
	
}
