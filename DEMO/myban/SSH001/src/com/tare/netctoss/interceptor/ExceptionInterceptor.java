package com.tare.netctoss.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 通用的异常处理拦截器
 * @author Administrator
 *
 */
public class ExceptionInterceptor implements Interceptor{

	public void destroy() {
	}

	public void init() {		
	}
	
	//处理所有异常
	public String intercept(ActionInvocation ai) throws Exception {
		try {
			return ai.invoke();//若没有异常，则ai.invoke()方法返回success.
		} catch (Exception e) {
			return "error";//处理异常报错时转向的统一的错误页面，即拦截所有业务方法，当捕获到其中有异常时，返回error,则Result到异常页面。
		}
	}
	
}
