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
		
		System.out.println("init LifeServlet!");//----表示要初始化Servlet----只有1次初始化
		System.out.println("config:"+config);	//----主要预置数据，只要servlet活着的时候都可以使用
		System.out.println(
				config.getInitParameter("company"));
			System.out.println(
				config.getInitParameter("city"));
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {		//----可以被调用多次
			System.out.println("LifeSerlet.service()");//----输出表示这个方法被调用了。
			//读取预置的数据
			ServletConfig cfg = getServletConfig();
			System.out.println(cfg.getInitParameter("company"));
			System.out.println(cfg.getInitParameter("city"));
	}

	@Override
	public void destroy() {//----爷爷类的销毁的方法
		// TODO Auto-generated method stub
		super.destroy();//----会销毁一些资源，建议保留
		System.out.println("destroy LifeServlet!!");
		ServletConfig cfg = getServletConfig();
		System.out.println(
			cfg.getInitParameter("company"));
		System.out.println(
			cfg.getInitParameter("city"));
	}
	
	
}
