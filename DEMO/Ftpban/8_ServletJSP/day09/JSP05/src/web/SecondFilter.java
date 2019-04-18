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
	
	public SecondFilter() {
		System.out.println("����SecondFilter");
	}

	@Override
	public void destroy() {
		System.out.println("����SecondFilter");
	}

	@Override
	public void doFilter(ServletRequest req, 
			ServletResponse res,
			FilterChain chain) 
		throws IOException, ServletException {
		System.out.println(city);
		System.out.println("SecondFilter��������");
		//�������ִ�У�������һ��Filter��
		//�������û��Filter�������Servlet��
		chain.doFilter(req, res);
		System.out.println("SecondFilter������Ӧ");
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		System.out.println("��ʼ��SecondFilter");
		city = cfg.getInitParameter("city");
	}

}





