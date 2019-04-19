package web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 用于计算在线人数的监听器
 * @author Administrator
 *
 */
public class CountListener  implements HttpSessionListener{
	//公开的一直存在的属性，用于储存属性
	private int count = 0;//计数
	
	//session被创建时调用
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("一个session被创建");
		//通过事件对象找到session
		HttpSession session = arg0.getSession();//通过事件对象获取session
		ServletContext sctx = session.getServletContext();
		count ++;
		sctx.setAttribute("count", count);//将count绑定到上下文对象中。
	}

	//session被销毁时调用
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();//通过事件对象获取session
		ServletContext sctx = session.getServletContext();
		count --;
		sctx.setAttribute("count", count);//将count绑定到上下文对象中。		
		System.out.println("一个session被删除了");
	}
	
	
}
