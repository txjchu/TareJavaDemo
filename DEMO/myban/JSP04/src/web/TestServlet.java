package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ���Ǹ���ϰ�������õ�ַ��servlet
 * @author Administrator
 *
 */
public class TestServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		out.println("<h1>���servlet�ķ��ʵ�ַ�ǣ�http://localhost:9080/JSP04/bbb</h1>");
	}
	
}
