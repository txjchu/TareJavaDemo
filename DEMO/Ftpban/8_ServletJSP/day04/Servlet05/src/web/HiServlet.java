package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {

	//ԭʼ�Ĺ���
	private double salary = 1000;
	
	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		synchronized(this) {
			//ÿ�η��ʸ�Servlet������salary+100
			salary += 100;
			//ģ�������ӳ�
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//����н��Ĺ�������������
			res.setContentType(
				"text/html;charset=utf-8");
			PrintWriter w = res.getWriter();
			w.println("<h1>��ǰ���ʣ�"+salary+"</h1>");
			w.close();
		}
	}
	
}




