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
		System.out.println("����SecondFilter");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("����SF");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		System.out.println(city);
		System.out.println("SFilter��������");
		//�������ִ�У�������һ��Filter���������û��Filter�������Servlet.
		chain.doFilter(req,res);
		System.out.println("SecondFilter������Ӧ");
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("��ʼ��SFilter");
		city = cfg.getInitParameter("city");
	}

}