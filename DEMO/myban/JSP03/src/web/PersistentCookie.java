package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 案例：设置cookie的保存时间		Persistent 固执的持久的
 * @author Administrator
 *
 */
public class PersistentCookie extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		Cookie[] cookies = req.getCookies();
		cookies[0].setMaxAge(100);
		cookies[1].setMaxAge(Integer.MAX_VALUE);//设置为永久有效
		out.print("修改cookie时间完成！<br/>");
		out.print("name:"+ cookies[0].getName() +",时间："+cookies[0].getMaxAge() +"<br/>");
		out.print("name:"+ cookies[1].getName() +",时间："+cookies[1].getMaxAge() +"<br/>");
		out.close();
		
		
		
	}
	
}
