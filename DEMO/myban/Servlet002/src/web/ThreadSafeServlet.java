package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * day03案例7 	测试线程安全
 * @author Administrator
 *
 */
public class ThreadSafeServlet extends HttpServlet{
	//设置个私有属性，测试线程安全
	private int count = 0;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset= utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		//加上同步锁后，新建线程必须等待之前创建的线程即之前的请求返回响应后，退出了同步代码才能被创建。保证一个线程运行中的私有属性的安全，不能同时被修改。
		synchronized (this) {
			count++;
			try {
				Thread.sleep(6000);//模拟网络延迟，可以在此时刷新多个页面，发送多个请求，用来修改count的值
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			out.println(Thread.currentThread().getName() + ":" + count);
		}
		
	}
	
}
