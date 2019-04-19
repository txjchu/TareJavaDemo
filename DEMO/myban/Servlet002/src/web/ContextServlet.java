package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * day03ϰ��6		��ϰ������
 * @author Administrator
 *
 */
public class ContextServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		//��ȡȫ�ֵ������Ķ���
		/*
		 * �������еı�����Ϊ���Ǵ���ͬһ��web�����У����õ�һ��ȫ�ֱ�����������ͨ�õġ�
		 */
		ServletContext con = getServletContext();
		Object count = con.getAttribute("count");
//		System.out.println("c:"+ count);
		if(count == null){
			//��ȡweb�ж�context�������еļ�ֵ�����õĳ�ʼֵ
			con.setAttribute("count", con.getInitParameter("count"));//��ʼվ��������������������û��count��ֵ�ԣ��򴴽�
		}else {
			con.setAttribute("count", Integer.parseInt( count.toString()) + 1);//������count,���1
		}
		out.println("���������"+ con.getAttribute("count"));
	}
	
}
