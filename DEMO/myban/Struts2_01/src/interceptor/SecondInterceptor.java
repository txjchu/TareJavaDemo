package interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * ��չ���������ڶ�����������������ϰ������ջ
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
		System.out.println("-->SecondInterceptor:������ǰ�ö���...[ǰ��]");
		ai.invoke();
		System.out.println("-->SecondInterceptor:���������ö���...[����]");
		return "error";
	}
	
}
