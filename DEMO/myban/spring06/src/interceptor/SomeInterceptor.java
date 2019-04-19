package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 演示：拦截器
 * @author Administrator
 *
 */
public class SomeInterceptor implements HandlerInterceptor{
	/**
	 * 前端控制器调用Controller(二级控制器)的方法前先执行preHandle方法。
	 * 如果该方法返回false，表示中断调用。
	 * 如果返回true，则继续向下调用(调用二级控制器的处理方法)。
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {		//----第3个参数，表示二级控制器的方法的对象。(使用的是Java的反射对象)
		System.out.println("拦截器的preHandle正在执行...");
		return true;
	}
	/**
	 * Controller二级控制器的方法执行完毕之后 ，但是在二级控制器将ModelAndView返回给前端控制器之前被调用。
	 * 
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView mav) throws Exception {
		/**
		 * 可以在拦截器当中，修改二级控制器返回给前端控制器的ModelAndView.
		 */
		mav.addObject("msg", "hahaha");
		System.out.println("拦截器的postHandle方法...");
	}
	/**
	 * 最后执行的一个方法
	 */	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
				throws Exception {
		System.out.println("拦截器的afterCompletion方法....");
	}
}
