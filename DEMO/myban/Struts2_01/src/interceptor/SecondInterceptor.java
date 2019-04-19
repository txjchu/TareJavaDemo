package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 扩展拦截器，第二个拦截器，用来练习拦截器栈
 * @author Administrator
 *
 */
public class SecondInterceptor implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation ai) throws Exception {
		System.out.println("-->SecondInterceptor:拦截器前置动作...[前置]");
		ai.invoke();
		System.out.println("-->SecondInterceptor:拦截器后置动作...[后置]");
		return "error";
	}
	
}
