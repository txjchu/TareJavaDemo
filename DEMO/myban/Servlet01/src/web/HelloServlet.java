package web;
//����������࣬�̳���HttpServlet����д����
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	//�Զ����ɵ�----�Ҽ�--Source--@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//1.����������ݵ�����
		res.setContentType("text/html");
		//2.��ȡWriter
		PrintWriter w = res.getWriter();
		//3.��������(HTMLƬ��)
		w.println("<h1>Hello,Servlet.</h1>");
		//4.�ر�Writer
		w.close();
		//5.����
	}

}
