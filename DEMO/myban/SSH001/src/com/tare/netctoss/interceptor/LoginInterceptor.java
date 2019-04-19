package com.tare.netctoss.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.tare.netctoss.entity.Admin;

/**
 * 登录验证拦截器-使用session中的数据进行验证。
 * @author Administrator
 *
 */
public class LoginInterceptor implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation ai) throws Exception {
		Map<String, Object> session = ai.getInvocationContext().getSession();//获取session
		Object admin = session.get("admin");
		System.out.println("-->进入了登录拦截器，获取到的admin:"+ admin);
		if(admin == null){
			return "login";//若session中的admin不存在，则返回到login页面。
		}else {
			String aiinvokeReturn = ai.invoke();
//			System.out.println(aiinvokeReturn);//返回的就是Action业务方法中的返回值字符串。success等。
			return aiinvokeReturn;
		}
	}

	
}
