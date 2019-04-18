package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet {
	public LifeServlet(){
		System.out.println("new one LifeServlet");
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		
		System.out.println("init LifeServlet!");//----��ʾҪ��ʼ��Servlet----ֻ��1�γ�ʼ��
		System.out.println("config:"+config);	//----��ҪԤ�����ݣ�ֻҪservlet���ŵ�ʱ�򶼿���ʹ��
		System.out.println(
				config.getInitParameter("company"));
			System.out.println(
				config.getInitParameter("city"));
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {		//----���Ա����ö��
			System.out.println("LifeSerlet.service()");//----�����ʾ��������������ˡ�
			//��ȡԤ�õ�����
			ServletConfig cfg = getServletConfig();
			System.out.println(cfg.getInitParameter("company"));
			System.out.println(cfg.getInitParameter("city"));
	}

	@Override
	public void destroy() {//----үү������ٵķ���
		// TODO Auto-generated method stub
		super.destroy();//----������һЩ��Դ�����鱣��
		System.out.println("destroy LifeServlet!!");
		ServletConfig cfg = getServletConfig();
		System.out.println(
			cfg.getInitParameter("company"));
		System.out.println(
			cfg.getInitParameter("city"));
	}
	
	
}
