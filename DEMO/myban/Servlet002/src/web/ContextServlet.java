package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * day03习题6		练习上下文
 * @author Administrator
 *
 */
public class ContextServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		//获取全局的上下文对象
		/*
		 * 上下文中的变量因为都是处于同一个web程序中，公用的一个全局变量，所以是通用的。
		 */
		ServletContext con = getServletContext();
		Object count = con.getAttribute("count");
//		System.out.println("c:"+ count);
		if(count == null){
			//获取web中对context上下文中的键值对设置的初始值
			con.setAttribute("count", con.getInitParameter("count"));//开始站长计数，即若上下文中没有count键值对，则创建
		}else {
			con.setAttribute("count", Integer.parseInt( count.toString()) + 1);//若存在count,则加1
		}
		out.println("总浏览量："+ con.getAttribute("count"));
	}
	
}
