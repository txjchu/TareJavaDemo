package web;
/**
 * �жϵ�ǰʵ�ֵ����ĸ�ģ��
 * ����ģ�����š�
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
		//��doFilterǰ���ز��ж�
		//����URI�жϵ�ǰ�����Ӧ��ģ��
		String uri = request.getRequestURI();
		int module = 0;//��ǰģ�����
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
		//��ģ����Ŵ���session
		request.getSession();
		//�������ִ��
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {


	}

}
