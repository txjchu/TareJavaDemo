package web;

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

/**
 *	��¼��飬�ڷ������е�����(�򿪵�¼ҳ����¼��
 *	������֤�����)ǰ������Ҫ�ж��û��Ƿ��¼����
 *	�жϵ����ݣ����Գ��Դ�session�ж�ȡadminCode��
 *	����¼��������ݴ��ڣ���֮�򲻴��ڡ�
 */
public class LoginFilter implements Filter {
	
	//����Ҫ���˵�·��
	String[] paths;

	@Override
	public void destroy() {

	}

	/**
	 * @param req
	 * 	�������HttpServletRequest
	 * @param res
	 * 	�������HttpServletResponse
	 * */
	@Override
	public void doFilter(
		ServletRequest req, 
		ServletResponse res, 
		FilterChain chain) 
		throws IOException, ServletException {
		HttpServletRequest request = 
			(HttpServletRequest) req;
		HttpServletResponse response = 
			(HttpServletResponse) res;
		//������Ҫ�жϵ������ų�
		//toLogin.do,login.do,createImage.do
		String uri = request.getRequestURI();
		uri = uri.replace(
			request.getContextPath(), "");
		//����������Ҫ�ų���·��
		for(String path : paths) {
			if(path.equals(uri)) {
				//�����ǰ�������Ҫ�ų���·����
				//��Ҫ���ˣ��������ִ�С�
				chain.doFilter(req, res);
				return;
			}
		}
		
		//�ж��û��Ƿ��¼��
		HttpSession session = 
			request.getSession();
		String adminCode = (String)
			session.getAttribute("adminCode");
		if(adminCode == null) {
			//û��¼���ض���toLogin.do
			response.sendRedirect(
				request.getContextPath() + 
				"/login/toLogin.do");
		} else {
			//�ѵ�¼���������ִ��
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		//��ȡ����Ҫ���˵�·��
		String str = 
			cfg.getInitParameter("excludePath");
		paths = str.split(",");
	}

}






