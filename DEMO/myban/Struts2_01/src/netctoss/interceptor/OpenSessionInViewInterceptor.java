package netctoss.interceptor;

import netctoss.util.HibernateUtil;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * OpenSessionInView拦截器：
 * 避免在Action处理请求完毕之前，因为session在延迟加载中，提前关闭后造成页面没有获取到数据。
 * @author Administrator
 *
 */
public class OpenSessionInViewInterceptor implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation ai) throws Exception {
		ai.invoke();//执行了Action业务方法，并处理了其返回值调用了Result，此时页面Jsp开始获取数据。
		HibernateUtil.close();//等Action的业务方法执行完毕，再关闭Session
		return null;
	}
	
}
