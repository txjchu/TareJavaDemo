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
		//初始化一些数据
		User user = new User();
		user.setUserName("Cang");
		user.setPassword("123");
		user.setSex("Male");
		user.setLoves(new String[] {"摄影","表演"});
		Course c = new Course();
		c.setId(1);
		c.setName("Java");
		c.setDays(85);
		user.setCourse(c);
		//将数据转发给hello.jsp
		req.setAttribute("user", user);
		// /JSP02/WEB-INF/hello.jsp
		// /JSP02/hello
		String url = "WEB-INF/hello.jsp";
		req.getRequestDispatcher(url)
			.forward(req, res);
	}

	
	
}




