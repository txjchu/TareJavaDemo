package web;
/**
 * ��¼��飬�ڷ������е�����(�򿪵�¼ҳ����¼��������֤�����)ǰ������Ҫ�ж��û��Ƿ��½����
 * �жϵ����ݣ����Գ��Դ�session�ж�ȡadminCode������¼��������ݴ��ڣ���֮�����ڡ�
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
	 * @param req �����HttpServletRequest
	 * @param res �������HttpServletResponse
	 * @Override
	 */
	String[] paths;
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		//ִ��doFilter()֮ǰ����Ҫ�ж��û��Ƿ��¼��
		//ǿ��ת��
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		//������Ҫ�жϵ������ų�
		//toLogin��do,login.do��createImage.do
		String uri = request.getRequestURI();
		uri = uri.replace(request.getContextPath(), "");
		//����������Ҫ�ų���·����
		for(String path : paths){
			if(path.equals(uri)){
				//�����ǰ�������Ҫ�ų���·������Ҫ���ˣ�����������ܸ�Ч��
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
		
		//�ж��û��Ƿ��¼��
		HttpSession session = request.getSession();
		String adminCode = (String)session.getAttribute("adminCode");
		if(adminCode == null){
			//û��¼�����ض���toLogin.do
			response.sendRedirect(request.getContextPath()+"/login/toLogin.do");
		}else{
			//�ѵ�¼���������ִ�С�
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		//��ȡ����Ҫ���˵�·��(�Ƕ���ַ���ƴ�ӵ��ַ���)----Ԥ�ò���
		String str = cfg.getInitParameter("excludePath");
		paths = str.split(",");
		
		
	}
}
