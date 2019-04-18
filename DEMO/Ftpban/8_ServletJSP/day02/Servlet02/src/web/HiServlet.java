package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//��ȡ�������ݰ��е�����
		//1.������
		System.out.println(
			"����ʽ:"+req.getMethod());
		System.out.println(
			"Servlet·��:"+req.getServletPath());
		System.out.println(
			"Э������:"+req.getProtocol());
		//2.��Ϣͷ(key-value)
		//getHeaderNames()�����е�key
		Enumeration e = req.getHeaderNames();
		while(e.hasMoreElements()) {
			String key = 
				e.nextElement().toString();
			//����keyȡvalue
			String value = req.getHeader(key);
			System.out.println(key+":"+value);
		}
		//3.ʵ������
		//��ǰ����û�д��Σ�����ʵ������Ϊ�գ��޷���ȡ��
		//4.����·��
		System.out.println(
			"URI:"+req.getRequestURI());
		System.out.println(
			"URL:"+req.getRequestURL());
		
		//ʹ��response����д��Ӧ��Ϣ
		//1.״̬�У��Զ����ɣ�ͨ�������Լ�д
		//2.��Ϣͷ���кܶ����ԣ�ͨ��ֻдcontentType
		//������������뷽��
		res.setContentType(
			"text/html;charset=utf-8");
		//���÷��������뷽��
		//���������contentType����
		//characterEncodingĬ�Ϻ���һ�¡�
//		res.setCharacterEncoding("utf-8");
		PrintWriter w = res.getWriter();
		//3.ʵ�����ݣ�д������Ӧ�����ص�����
		w.println("<h1>���,Servlet.</h1>");
		w.close();
	}

	
	
}



