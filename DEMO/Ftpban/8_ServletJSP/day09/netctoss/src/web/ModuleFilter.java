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
 * �жϱ������������ĸ�ģ�顣
 * ����ģ�����ţ�
 * 	0-��ҳ��1-��ɫ��2-����Ա��3-�ʷѣ�...
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
		//����URI�жϵ�ǰ�����Ӧ��ģ��
		String uri = request.getRequestURI();
		int module = 0; //��ǰģ�����
		if(uri.contains("role")) {
			module = 1;
		} else if(uri.contains("admin")) {
			module = 2;
		} else if(uri.contains("cost")) {
			module = 3;
		} 
		//��ģ����Ŵ���session
		request.getSession()
			.setAttribute("module", module);
		//�������ִ��
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
