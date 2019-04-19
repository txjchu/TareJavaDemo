package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ���ڼ������������ļ�����
 * @author Administrator
 *
 */
public class CountListener  implements HttpSessionListener{
	//������һֱ���ڵ����ԣ����ڴ�������
	private int count = 0;//����
	
	//session������ʱ����
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("һ��session������");
		//ͨ���¼������ҵ�session
		HttpSession session = arg0.getSession();//ͨ���¼������ȡsession
		ServletContext sctx = session.getServletContext();
		count ++;
		sctx.setAttribute("count", count);//��count�󶨵������Ķ����С�
	}

	//session������ʱ����
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();//ͨ���¼������ȡsession
		ServletContext sctx = session.getServletContext();
		count --;
		sctx.setAttribute("count", count);//��count�󶨵������Ķ����С�		
		System.out.println("һ��session��ɾ����");
	}
	
	
}
