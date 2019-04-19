package web;
/**
 * 演示：Servlet和filter的顺序
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	public HelloServlet(){
		System.out.println("创建Servlet");
	}
	
	//重写方法	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("初始化Servlet");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("调用Servlet");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		w.println("<h1>Hello.<h1>");
		w.close();
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("销毁Servlet");
	}
	
}
