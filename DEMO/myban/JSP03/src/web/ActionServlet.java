package web;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {
	//�򿪵�¼ҳ�棺/JSP03/login/toLogin.do
	//��¼��/JSP03/login/login.do	
	//����ҳ��/JSP03/main/toIndex.do
	//��¼ҳ��/WEB-INF/login.jsp
	//��ҳ��/WEB-INF/index.jsp
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		String uri = req.getRequestURI();
		uri = uri.replace(req.getContextPath(),"");//----��uri
		if(uri.equals("/login/toLogin.do")){
			//�򿪵�¼ҳ
			toLogin(req,res);
		}else if(uri.equals("/login/login.do")){
			//��¼
			login(req,res);
		}else if(uri.equals("/main/toIndex.do")){
			//����ҳ
			toIndex(req,res);
		}
	}
	protected void toLogin(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		req.getRequestDispatcher("../WEB-INF/login.jsp").forward(req, res);
	}
	
	protected void login(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		//��ȡ������
		String userName = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		String rmb = req.getParameter("remember");
		//��֤��������֤ͨ����
		//��ס��
		//�����ѡ�˸�ѡ�򣬾��Ǽ�ס�ң�----��yes��rmbλ�ã�����д�����ָ���쳣��
		if("yes".equals(rmb)){
			//ʹ��cookie��¼�˺źͼ�ס��
			//���ڴ�����������е�һЩ����ҵ������ҳ��ʾ�˺ţ��ٴδ򿪵�¼ҳʱ��Ĭ���˺ţ�
			
			Cookie c = new Cookie("userName",userName);//����Cookie����¼�˺š�
			//Ĭ��ֻ�Ե�ǰ·���µ���Դ��Ч��/JSP03/login/     �����ֶ���������Ч��·����
			c.setPath(req.getContextPath());	
			
			//Ĭ������£�cookie�浽����������У�������ر���cookie��ʧ��
			//��ϣ��������ر�ʱcookie����ʧ����Ҫ�����cookie���ù���ʱ�䣬��ôcookie�ڹر���������ܴ����ô����ʱ�䡣
			c.setMaxAge(3600);
			
			
			//����Cookie���͸��ͻ��˱���
			res.addCookie(c);
			//��ס�ң�����ͨ��userName�жϳ�������������ļ�¼����			
		}
		Cookie c2 = new Cookie("city","BeiJing");
		c2.setPath(req.getContextPath());//----����·����ֻҪ�������Ŀ�¶�����ʹ�����cookie
		c2.setMaxAge(3600);
		res.addCookie(c2);//-----�����ͻ���
		
		Cookie c3 = new Cookie("home",URLEncoder.encode("�Ϻ�","utf-8"));//���д�����ģ�����Ҫʹ��URLEncoder.
		c3.setPath(req.getContextPath());
		c3.setMaxAge(3600);
		res.addCookie(c3);
		
		//�ض�����ҳ
		//��ǰ��/JSP03/login/login.do
		//Ŀ�꣺/JSP03/main/toindex.do
		res.sendRedirect("../main/toIndex.do");
		
	}
	//����ҳ
	protected void toIndex(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		//��ȡ��������ݹ�����cookie������ӡ�����ǵ����ݡ�
		Cookie[] cs = req.getCookies();
		for(Cookie c:cs){
			//�޸�cookie
			if(c.getName().equals("city")){
				c.setValue("ShenZhen");
				res.addCookie(c);
			}
			if(c.getName().equals("home")){
				System.out.println(URLDecoder.decode(c.getValue(),"utf-8"));
			}else{	
			//��ȡ�������
			System.out.println(c.getName()+":"+c.getValue());
			}
		}
		//ת��
		req.getRequestDispatcher("../WEB-INF/index.jsp").forward(req, res);
	}
}
