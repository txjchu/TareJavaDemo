package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 判断本次请求属于哪个模块。
 * 返回模块的序号：
 * 	0-主页；1-角色；2-管理员；3-资费；...
 */
public class ModuleFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(
		ServletRequest req, 
		ServletResponse res,
		FilterChain chain) 
		throws IOException, ServletException {
		HttpServletRequest request = 
			(HttpServletRequest) req;
		//根据URI判断当前请求对应的模块
		String uri = request.getRequestURI();
		int module = 0; //当前模块序号
		if(uri.contains("role")) {
			module = 1;
		} else if(uri.contains("admin")) {
			module = 2;
		} else if(uri.contains("cost")) {
			module = 3;
		} 
		//将模块序号存入session
		request.getSession()
			.setAttribute("module", module);
		//请求继续执行
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
