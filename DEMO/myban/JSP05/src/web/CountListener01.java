package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器2
 * @author Administrator
 *
 */
public class CountListener01 implements HttpSessionListener{
	private int count = 0;
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		ServletContext context = session.getServletContext();
		count ++;
		context.setAttribute("count", count);
		System.out.println("创建了一个session...");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		ServletContext context = session.getServletContext();
		count --;
		context.setAttribute("count", count);
		System.out.println("销毁了一个session...");
		
	}
	
}
