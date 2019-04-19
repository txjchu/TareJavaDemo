package web;
/**
 * ��ʾ��Servlet��filter��˳��
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
		System.out.println("����Servlet");
	}
	
	//��д����	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("��ʼ��Servlet");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("����Servlet");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		w.println("<h1>Hello.<h1>");
		w.close();
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("����Servlet");
	}
	
}
