package Controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HelloService;


public class ActionServlet extends HttpServlet {


	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ActionServlet's service方法...");
		/*
		 * Http://ip:post/spring03_web01/hello.do
		 */
		String uri = request.getRequestURI();
		/*
		 * uri:		/spring03_web01/hello.do
		 */
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		if("/hello".equals(action)){
			HelloService service = new HelloService();
			String flag = service.execute();	//----该方法会有个返回值
			System.out.println(flag);
			/**
			 * 什么是绝对路径？
			 * 	以“/”开头的路径。
			 *  
			 * 绝对路径怎么写：
			 * 	链接，表单提交，重定向从应用名开始写；
			 * 	转发从应用名之后开始写。
			 */
			request.getRequestDispatcher("/WEB-INF/hello.jsp").forward(request,response);
		}else if("/login".equals(action)){
			HelloService service = new HelloService();
			String flag = service.execute();	//----该方法会有个返回值
			System.out.println(flag);
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
			
		}
	}

}
