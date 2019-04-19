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
		System.out.println("ActionServlet's service����...");
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
			String flag = service.execute();	//----�÷������и�����ֵ
			System.out.println(flag);
			/**
			 * ʲô�Ǿ���·����
			 * 	�ԡ�/����ͷ��·����
			 *  
			 * ����·����ôд��
			 * 	���ӣ����ύ���ض����Ӧ������ʼд��
			 * 	ת����Ӧ����֮��ʼд��
			 */
			request.getRequestDispatcher("/WEB-INF/hello.jsp").forward(request,response);
		}else if("/login".equals(action)){
			HelloService service = new HelloService();
			String flag = service.execute();	//----�÷������и�����ֵ
			System.out.println(flag);
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
			
		}
	}

}
