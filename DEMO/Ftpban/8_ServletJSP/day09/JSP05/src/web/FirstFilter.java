package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter {
	
	public FirstFilter() {
		System.out.println("创建FirstFilter");
	}

	@Override
	public void destroy() {
		System.out.println("销毁FirstFilter");
	}

	//过滤方法，可以在请求开始阶段过滤请求，
	//也可以在请求结束阶段过滤响应，即它可以
	//实现请求和响应的双层过滤。
	//过滤：过滤敏感词/记录日志/权限检查...
	//     处理一切Servlet间通用的业务。
	@Override
	public void doFilter(
		ServletRequest req, 
		ServletResponse res,
		FilterChain chain) 
		throws IOException, ServletException {
		//过滤请求的代码
		System.out.println("FirstFilter过滤请求");
		//FilterChain：过滤链。
		//doFilter方法是递归调用下一个Filter。
		//通常每个Filter中都会调用chain.doFilter()，
		//这样递归的调用下去，直到最后一个Filter为止。
		//即：调用下一个Filter。
		//如果没有写doFilter()，链就断了，即请求会中断。
		//就不会抵达Servlet。
		//所有的Filter都调用完，就会调用Servlet。
		chain.doFilter(req, res);
		//过滤响应的代码
		System.out.println("FirstFilter过滤响应");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化FirstFilter");
	}

}
