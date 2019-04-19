package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeServlet extends HttpServlet {

	public LifeServlet() {
		System.out.println("new LifeServlet");
	}

	@Override
	public void init(ServletConfig config) 
		throws ServletException {
		super.init(config);
		System.out.println("init LifeServlet");
		System.out.println("config: "+config);
		System.out.println(
			config.getInitParameter("company"));
		System.out.println(
			config.getInitParameter("city"));
	}

	@Override
	protected void service(
		HttpServletRequest arg0, 
		HttpServletResponse arg1)
		throws ServletException, IOException {
		System.out.println(
			"LifeServlet.service()");
		//��ȡԤ�õ�����
		ServletConfig cfg = getServletConfig();
		System.out.println(
			cfg.getInitParameter("company"));
		System.out.println(
			cfg.getInitParameter("city"));
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy LifeServlet");
		//��ȡԤ�õ�����
		ServletConfig cfg = getServletConfig();
		System.out.println(
			cfg.getInitParameter("company"));
		System.out.println(
			cfg.getInitParameter("city"));
	}
	
	
	
}








