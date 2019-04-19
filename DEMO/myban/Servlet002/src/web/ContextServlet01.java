package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ͬContetServlet
 * @author Administrator
 *
 */
public class ContextServlet01 extends HttpServlet{
	private int num = 0;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		
		num ++;
		System.out.println(num);
		try {
			Thread.sleep(1000);//ģ�������ӳ�
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +":"+ num);
		out.println(Thread.currentThread().getName() +"::"+ num);
		
		//��ȡȫ�ֵ������Ķ���
		ServletContext con = getServletContext();
		Object count = con.getAttribute("count");
//		System.out.println("c1:"+ count);
		if(count == null){
			//�޸�context-para���Ժ���Ҫ���²�����ܻ�ԭcontext�������²�������tomcat
			con.setAttribute("count", con.getInitParameter("count"));//��ʼվ��������������������û��count��ֵ�ԣ��򴴽�
		}else {
			con.setAttribute("count", Integer.parseInt(count.toString()) + 1);//������count,���1
		}
		out.println("���������"+ con.getAttribute("count"));
	}
	
}
