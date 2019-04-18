package org.tarena.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SomeInterceptor //implements Interceptor{
	extends AbstractInterceptor{
	
	//该方法返回值只有在不执行invoke()方法时有意义
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("执行Action前追加逻辑");
		invocation.invoke();//调用Action+Result
//		invocation.invokeActionOnly()
		System.out.println("执行Result后追加逻辑");
		return null;
	}
	
}
