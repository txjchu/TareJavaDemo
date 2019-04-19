package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ���ڼ������������ļ�����
 * ����session�Ĵ���������
 * @author Administrator
 *
 */
public class CountListener implements HttpSessionListener{
	private int count = 0;//����
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("001��һ��session������");
		HttpSession session = arg0.getSession();
		ServletContext context = session.getServletContext();
		count ++;
		context.setAttribute("count", count);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("001��һ��session��������");
		HttpSession session = arg0.getSession();
		ServletContext context = session.getServletContext();
		count --;
		context.setAttribute("count", count);		
		
	}
	
}
