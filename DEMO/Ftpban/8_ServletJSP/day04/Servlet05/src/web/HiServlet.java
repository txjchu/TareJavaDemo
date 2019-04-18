package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {

	//原始的工资
	private double salary = 1000;
	
	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		synchronized(this) {
			//每次访问该Servlet，都将salary+100
			salary += 100;
			//模拟网络延迟
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//将涨薪后的工资输出给浏览器
			res.setContentType(
				"text/html;charset=utf-8");
			PrintWriter w = res.getWriter();
			w.println("<h1>当前工资："+salary+"</h1>");
			w.close();
		}
	}
	
}




