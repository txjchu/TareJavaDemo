package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����
 * @author Administrator
 *
 */
public class HelloServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//1.����������ݵ�����
		res.setContentType("text/html");
		//2.��ȡWriter
		PrintWriter pw = res.getWriter();//����Ӧ�����ȡ���������Ϊ����Ӧ������������ͻ���д����Ϣ
		//3.������ݣ�HTMLƬ�Σ�
		pw.println("<h1>Hello,Servlet.</h1>");
		//4.�ر�writer
		pw.close();

	}
	
}















