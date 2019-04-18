package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {

	//�򿪵�¼ҳ��/JSP03/login/toLogin.do
	//��¼��/JSP03/login/login.do
	//����ҳ��/JSP03/main/toIndex.do
	//��¼ҳ��/WEB-INF/login.jsp
	//��ҳ��/WEB-INF/index.jsp
	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType(
			"text/html;charset=utf-8");
		String uri = req.getRequestURI();
		uri = uri.replace(
			req.getContextPath(), "");
		if(uri.equals("/login/toLogin.do")) {
			//�򿪵�¼ҳ
			toLogin(req, res);
		} else if (uri.equals("/login/login.do")) {
			//��¼
			login(req, res);
		} else if (uri.equals("/main/toIndex.do")) {
			//����ҳ
			toIndex(req, res);
		}
	}

	protected void toLogin(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		req.getRequestDispatcher(
			"../WEB-INF/login.jsp").forward(req, res);
	}
	
	protected void login(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//��ȡ������
		String userName = 
			req.getParameter("userName");
		String pwd = 
			req.getParameter("pwd");
		String rmb = 
			req.getParameter("remember");
		//��֤��������֤ͨ����
		//��ס��
		if("yes".equals(rmb)) {
			//ʹ��cookie��¼�˺źͼ�ס�ң�
			//���ڴ�����������е�һЩ����ҵ��
			//��ҳ��ʾ�˺ţ�
			//�ٴδ򿪵�¼ҳʱ����Ĭ���˺ţ�
			//����Cookie����¼�˺�
			//Ĭ��ֻ�Ե�ǰ·���µ���Դ��Ч��
			//JSP03/login/
			//�����ֶ���������Ч��·��
			Cookie c = new Cookie(
				"userName", userName);
			//���ø�cookie��������Ŀ�¶���Ч
			c.setPath(req.getContextPath());
			//����Cookie���͸��ͻ��˱���
			res.addCookie(c);
			//��ס�ҿ���ͨ��userName�жϳ�����
			//��������ļ�¼����
		}
		//�ض�����ҳ
		//JSP03/login/login.do
		//JSP03/main/toIndex.do
		res.sendRedirect("../main/toIndex.do");
	}
	
	protected void toIndex(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//��ȡ��������ݹ�����cookie��
		//����ӡ�����ǵ����ݡ�
		Cookie[] cs = req.getCookies();
		for(Cookie c : cs) {
			System.out.println(
				c.getName() + ":" +
				c.getValue());
		}
		
		req.getRequestDispatcher(
			"../WEB-INF/index.jsp").forward(req, res);
	}
	
	
}






