package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 用于计算在线人数的监听器
 * 监听session的创建和销毁
 * @author Administrator
 *
 */
public class CountListener implements HttpSessionListener{
	private int count = 0;//计数
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("001的一个session创建了");
		HttpSession session = arg0.getSession();
		ServletContext context = session.getServletContext();
		count ++;
		context.setAttribute("count", count);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("001的一个session被销毁了");
		HttpSession session = arg0.getSession();
		ServletContext context = session.getServletContext();
		count --;
		context.setAttribute("count", count);		
		
	}
	
}
