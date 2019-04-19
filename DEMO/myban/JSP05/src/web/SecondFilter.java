package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SecondFilter implements Filter {
	
	String city;
	
	public SecondFilter(){
		System.out.println("创建SecondFilter");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("销毁SF");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		System.out.println(city);
		System.out.println("SFilter过滤请求");
		//请求继续执行，调用下一个Filter，如果后面没有Filter，则调用Servlet.
		chain.doFilter(req,res);
		System.out.println("SecondFilter过滤响应");
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("初始化SFilter");
		city = cfg.getInitParameter("city");
	}

}
