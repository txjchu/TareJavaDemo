package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ��ʾ��������
 * @author Administrator
 *
 */
public class SomeInterceptor implements HandlerInterceptor{
	/**
	 * ǰ�˿���������Controller(����������)�ķ���ǰ��ִ��preHandle������
	 * ����÷�������false����ʾ�жϵ��á�
	 * �������true����������µ���(���ö����������Ĵ�����)��
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {		//----��3����������ʾ�����������ķ����Ķ���(ʹ�õ���Java�ķ������)
		System.out.println("��������preHandle����ִ��...");
		return true;
	}
	/**
	 * Controller�����������ķ���ִ�����֮�� �������ڶ�����������ModelAndView���ظ�ǰ�˿�����֮ǰ�����á�
	 * 
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView mav) throws Exception {
		/**
		 * ���������������У��޸Ķ������������ظ�ǰ�˿�������ModelAndView.
		 */
		mav.addObject("msg", "hahaha");
		System.out.println("��������postHandle����...");
	}
	/**
	 * ���ִ�е�һ������
	 */	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
				throws Exception {
		System.out.println("��������afterCompletion����....");
	}
}
