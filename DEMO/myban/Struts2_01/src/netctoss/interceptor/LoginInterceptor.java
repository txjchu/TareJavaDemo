package netctoss.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 登录验证拦截器，用于检查用户是否登录
 * @author Administrator
 *
 */
public class LoginInterceptor implements Interceptor{

	public String intercept(ActionInvocation ai) throws Exception {
		System.out.println("-->LoginInterceptor：进入到登录拦截器前置方法了...");
		//获取session
		Map<String, Object> session = ai.getInvocationContext().getSession();
		Object admin = session.get("admin");//获取登录信息
		if(admin == null){//若没有获取到用户信息
			return "login";//返回登录页面
		} else {
			return ai.invoke();//获取到，则继续执行后续操作
		}
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
