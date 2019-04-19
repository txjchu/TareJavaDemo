package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 同ContetServlet
 * @author Administrator
 *
 */
public class ContextServlet01 extends HttpServlet{
	private int num = 0;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		
		num ++;
		System.out.println(num);
		try {
			Thread.sleep(1000);//模拟网络延迟
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +":"+ num);
		out.println(Thread.currentThread().getName() +"::"+ num);
		
		//获取全局的上下文对象
		ServletContext con = getServletContext();
		Object count = con.getAttribute("count");
//		System.out.println("c1:"+ count);
		if(count == null){
			//修改context-para属性后需要重新部署才能还原context。即重新部署并重启tomcat
			con.setAttribute("count", con.getInitParameter("count"));//开始站长计数，即若上下文中没有count键值对，则创建
		}else {
			con.setAttribute("count", Integer.parseInt(count.toString()) + 1);//若存在count,则加1
		}
		out.println("总浏览量："+ con.getAttribute("count"));
	}
	
}
