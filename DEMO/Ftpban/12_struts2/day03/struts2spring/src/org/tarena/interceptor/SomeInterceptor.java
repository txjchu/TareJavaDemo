package org.tarena.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SomeInterceptor //implements Interceptor{
	extends AbstractInterceptor{
	
	//�÷�������ֵֻ���ڲ�ִ��invoke()����ʱ������
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("ִ��Actionǰ׷���߼�");
		invocation.invoke();//����Action+Result
//		invocation.invokeActionOnly()
		System.out.println("ִ��Result��׷���߼�");
		return null;
	}
	
}
