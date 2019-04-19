package netctoss.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 自定义的拦截器，用于处理验证用户登录与否。
 * @author Administrator
 *
 */
public class SessionInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse res,
			Object arg2) throws Exception {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("admin");
		if(obj == null){
			//没有登录
			res.sendRedirect("toLogin.do");
			return false;
		}
		return true;
	}
	

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
	throws Exception {
	}



}
