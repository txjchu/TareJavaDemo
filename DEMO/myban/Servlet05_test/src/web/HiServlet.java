package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {
	private double salary = 10000 ;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	synchronized(this){		//----加锁
		//每次浏览HiServlet给salary增加数值
		salary += 1000;
		//模拟网络延迟，----
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//将涨薪后的工资输出给浏览器
		res.setContentType("text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		w.println("<h1>当前工资："+salary+"</h1>");
		w.close();
		}
		
	}
}
