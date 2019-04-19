package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * Struts2中的拦截器练习
 *	--需要实现Interceptor接口，并实现intercepte方法。
 * @author Administrator
 */
public class FirstInterceptor implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation ai) throws Exception {
		System.out.println("-->FirstInterceptor:拦截器前置动作...[前置]");
		ai.invoke();	//拦截器代理调用拦截处理请求的Action中的业务方法
		System.out.println("-->FirstInterceptor:拦截器后置动作...[后置]");
		return "error";
	}
	
	
}
