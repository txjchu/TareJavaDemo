package com.tare.netctoss.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * ͨ�õ��쳣����������
 * @author Administrator
 *
 */
public class ExceptionInterceptor implements Interceptor{

	public void destroy() {
	}

	public void init() {		
	}
	
	//���������쳣
	public String intercept(ActionInvocation ai) throws Exception {
		try {
			return ai.invoke();//��û���쳣����ai.invoke()��������success.
		} catch (Exception e) {
			return "error";//�����쳣����ʱת���ͳһ�Ĵ���ҳ�棬����������ҵ�񷽷����������������쳣ʱ������error,��Result���쳣ҳ�档
		}
	}
	
}
