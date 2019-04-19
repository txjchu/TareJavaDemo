package netctoss.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import netctoss.entity.Admin;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录验证拦截器
 * 用于验证用户发出的请求时是否已经登录。
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object arg2) throws Exception {
		Admin admin = (Admin) req.getSession().getAttribute("admin");//获取请求对象中session中保存的admin对象
		
		System.out.println("进入拦截器了...");
//		System.out.println("进入拦截器:"+ admin.getAdminCode() +":"+ admin.getPassword());//此方法会产生一个空指针异常，造成进入到了异常页面，从而没有执行下面的代码
		
		if(admin == null ){//若session中没有保存admin对象		|| 1>0
			
			//此时的req.getContextPath()为：/SpringNetctoss001
			res.sendRedirect(req.getContextPath()+ "/login/toLogin.do");//则重定向回登录页面
			return false;//并且返回false，不执行后面的控制器中的步骤
		}
		return true;//若验证成功，返回true，继续交给控制器处理。
	}
	
}
