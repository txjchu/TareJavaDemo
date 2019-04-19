package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {
	//��дservlet����
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		//��ȡ�������ݰ��е�����
		//1.------3���������е�����
		System.out.println("����ʽ��"+req.getMethod());
		System.out.println("Servlet·����"+req.getServletPath());
		System.out.println("Э������"+req.getProtocol());		//----HTTPЭ��İ汾
		
		//2.��Ϣͷ(key-value)
		//getHeaderNames()�������е�key
		Enumeration e = req.getHeaderNames();
		while(e.hasMoreElements()){
			String key = e.nextElement().toString();
			//����key��ȡvalue
			String value = req.getHeader(key);
			System.out.println(key+":"+value);
		}
		//3.URI��������Դ·������ǰ����û�д��Ͳ���������ʵ������Ϊ�ա�
		//4.URL������·����Ϣ
		System.out.println("URI:"+req.getRequestURI());	//----������Դ·��----(��Դ������)URI:/Servlet02/hi------(����ʦ������ʦ...)
		System.out.println("URL:"+req.getRequestURL());	//----����·����Ϣ----(��Դ����ʵ����)URL:http://localhost:9080/Servlet02/hi(������)
		
		//ʹ��response����д��Ӧ��Ϣ
		//1.״̬�У��Զ����ɣ�ͨ�������Լ�д��
		//2.��Ϣͷ���кܶ����ԣ�ͨ��ֻдcontentType��
		
				//������������뷽��
		res.setContentType("text/html;charset = utf-8");	//charset���������װ�����뷽��
		
				//������������뷽����----���������contentType,��characterEncodingĬ�Ϻ���һ�¡�
		res.setCharacterEncoding("utf-8");			//----������contentType,�Ϳ��Բ����ø�����
		
		PrintWriter w = res.getWriter();
		//3.ʵ�����ݣ�д������Ӧ�����ص����ݡ�
		w.println("<h1>Hi���,Servlet!<h1>");
		w.close();
		//��web.xml��ע��
	}

}
