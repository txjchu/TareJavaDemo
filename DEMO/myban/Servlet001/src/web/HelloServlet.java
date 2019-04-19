package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 案例
 * @author Administrator
 *
 */
public class HelloServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//1.设置输出内容的类型
		res.setContentType("text/html");
		//2.获取Writer
		PrintWriter pw = res.getWriter();//从响应对象获取输出流，因为是响应对象向浏览器客户端写出消息
		//3.输出内容（HTML片段）
		pw.println("<h1>Hello,Servlet.</h1>");
		//4.关闭writer
		pw.close();

	}
	
}
















