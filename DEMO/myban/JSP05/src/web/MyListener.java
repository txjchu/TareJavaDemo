package web;
/**
 * 演示：监听器，用来见识request初始化和销毁的事件。
 * 		还有其他的监听器可以监听session,ServletContext对象的初始化和销毁事件，
 * 		也可以监听request，session,ServletContext数据变化的事件。
 * 		所有的监听器的用法都一样， 此处只演示ServletRequestListener。
 */
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener implements ServletRequestListener {
	
	//监听request销毁
	@Override
	public void requestDestroyed(ServletRequestEvent e) {
		System.out.println("销毁request！！！");
		e.getServletRequest();
		e.getServletContext();
		
	}
	
	//监听request初始化
	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("初始化request！！！");

	}

}
