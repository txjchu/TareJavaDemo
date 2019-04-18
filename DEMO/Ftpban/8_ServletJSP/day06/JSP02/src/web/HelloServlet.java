package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Course;
import entity.User;

public class HelloServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//��ʼ��һЩ����
		User user = new User();
		user.setUserName("Cang");
		user.setPassword("123");
		user.setSex("Male");
		user.setLoves(new String[] {"��Ӱ","����"});
		Course c = new Course();
		c.setId(1);
		c.setName("Java");
		c.setDays(85);
		user.setCourse(c);
		//������ת����hello.jsp
		req.setAttribute("user", user);
		// /JSP02/WEB-INF/hello.jsp
		// /JSP02/hello
		String url = "WEB-INF/hello.jsp";
		req.getRequestDispatcher(url)
			.forward(req, res);
	}

	
	
}




