package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor 
implements HandlerInterceptor{

	
	/**
	 * 前端控制器在调用Controller(二级控制器)
	 * 的方法之前先执行preHandle方法。
	 * 如果该方法返回false,表示中断调用，
	 * 否则继续向下调用。
	 */
	public boolean preHandle(HttpServletRequest 
			request, HttpServletResponse response,
			Object arg2) throws Exception {
		System.out.println("拦截器的preHandle方法...");
		return true;
	}
	
	/**
	 * Contoller(二级控制器)的方法执行完毕之后，
	 * 但是在二级控制器将ModelAndView返回给
	 * 前端控制器之前被调用。
	 */
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response,
			Object arg2, ModelAndView mav) throws Exception {
		/*
		 * 可以在拦截器当中，修改二级控制器返回给
		 * 前端控制器的ModelAndView。
		 */
		mav.addObject("msg", "hahaha");
		System.out.println("拦截器的postHandle方法...");
	}
	
	/**
	 * 最后执行的一个方法
	 */
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("拦截器的afterCompletion方法");
	}

	

}
