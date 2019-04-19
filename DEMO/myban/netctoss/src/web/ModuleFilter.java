package web;
/**
 * 判断当前实现的是哪个模块
 * 返回模块的序号。
 * 
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ModuleFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;		
		//在doFilter前拦截并判断
		//根据URI判断当前请求对应的模块
		String uri = request.getRequestURI();
		int module = 0;//当前模块序号
		if(uri.contains("role")){
			module = 1;
		}else if(uri.contains("admin")){
			module = 2 ;
		}else if(uri.contains("admin")){
			module = 3;
		}else if(uri.contains("admin")){
			module = 4;
		}else if(uri.contains("admin")){
			module = 5;
		}else if(uri.contains("admin")){
			module = 6;
		}else if(uri.contains("admin")){
			module = 7;
		}else if(uri.contains("admin")){
			module = 8;
		}
		//将模块序号存入session
		request.getSession();
		//请求继续执行
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {


	}

}
