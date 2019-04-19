package com.tare.netctoss.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.tare.netctoss.entity.Admin;

/**
 * ��¼��֤������-ʹ��session�е����ݽ�����֤��
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
		Map<String, Object> session = ai.getInvocationContext().getSession();//��ȡsession
		Object admin = session.get("admin");
		System.out.println("-->�����˵�¼����������ȡ����admin:"+ admin);
		if(admin == null){
			return "login";//��session�е�admin�����ڣ��򷵻ص�loginҳ�档
		}else {
			String aiinvokeReturn = ai.invoke();
//			System.out.println(aiinvokeReturn);//���صľ���Actionҵ�񷽷��еķ���ֵ�ַ�����success�ȡ�
			return aiinvokeReturn;
		}
	}

	
}
