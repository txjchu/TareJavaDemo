package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor 
implements HandlerInterceptor{

	
	/**
	 * ǰ�˿������ڵ���Controller(����������)
	 * �ķ���֮ǰ��ִ��preHandle������
	 * ����÷�������false,��ʾ�жϵ��ã�
	 * ����������µ��á�
	 */
	public boolean preHandle(HttpServletRequest 
			request, HttpServletResponse response,
			Object arg2) throws Exception {
		System.out.println("��������preHandle����...");
		return true;
	}
	
	/**
	 * Contoller(����������)�ķ���ִ�����֮��
	 * �����ڶ�����������ModelAndView���ظ�
	 * ǰ�˿�����֮ǰ�����á�
	 */
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object arg2, ModelAndView mav) throws Exception {
		/*
		 * ���������������У��޸Ķ������������ظ�
		 * ǰ�˿�������ModelAndView��
		 */
		mav.addObject("msg", "hahaha");
		System.out.println("��������postHandle����...");
	}
	
	/**
	 * ���ִ�е�һ������
	 */
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("��������afterCompletion����");
	}

	

}
