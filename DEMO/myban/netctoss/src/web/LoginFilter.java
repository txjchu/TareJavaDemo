package web;
/**
 * 登录检查，在访问所有的请求(打开登录页，登录，创建验证码除外)前，都需要判断用户是否登陆过。
 * 判断的依据：可以尝试从session中读取adminCode，若登录过则该数据存在，反之不存在。
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		

	}
	/**
	 * @param req 传入的HttpServletRequest
	 * @param res 传入的是HttpServletResponse
	 * @Override
	 */
	String[] paths;
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		//执行doFilter()之前，需要判断用户是否登录过
		//强制转型
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		//将不需要判断的请求排除
		//toLogin，do,login.do，createImage.do
		String uri = request.getRequestURI();
		uri = uri.replace(request.getContextPath(), "");
		//遍历所有需要排除的路径。
		for(String path : paths){
			if(path.equals(uri)){
				//如果当前请求就是要排除的路径，不要过滤，请求继续智能高效。
				chain.doFilter(req, res);
				return;
			}
		}
//		if(uri.equals("/login/toLogin.do")
//				||uri.equals("/login/login.do")
//				||uri.equals("/login/createImage.do")){
//			chain.doFilter(req, res);
//			return;
//		}
		
		//判断用户是否登录过
		HttpSession session = request.getSession();
		String adminCode = (String)session.getAttribute("adminCode");
		if(adminCode == null){
			//没登录过，重定向到toLogin.do
			response.sendRedirect(request.getContextPath()+"/login/toLogin.do");
		}else{
			//已登录，请求继续执行。
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		//获取不需要过滤的路径(是多个字符串拼接的字符串)----预置参数
		String str = cfg.getInitParameter("excludePath");
		paths = str.split(",");
		
		
	}
}
