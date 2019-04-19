package com.tare.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * �Զ���������
 * ��ϰ��������ʹ�ã���ִ��HelloController������ǰ������һ�仰
 * @author Administrator
 *
 */
public class FirstInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("�������ڿ�����������һ���������ִ����afterCompletion����...");
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("Controllerִ����Ϻ�����������һ��postHandle����...");
		
	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("����������һ��...preHandle����");
		return true;
	}
	
	
}
