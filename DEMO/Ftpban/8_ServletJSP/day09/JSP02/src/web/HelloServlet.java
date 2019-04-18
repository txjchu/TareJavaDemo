package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
		//要遍历的集合
		List<User> list = new ArrayList<User>();
		User u1 = new User();
		u1.setUserName("苍老师");
		list.add(u1);
		User u2 = new User();
		u2.setUserName("范传奇");
		list.add(u2);
		User u3 = new User();
		u3.setUserName("王克晶");
		list.add(u3);
		
		//要遍历的起点和终点
		int begin = 6;
		int end = 10;
		
		//将数据转发给hello.jsp
		req.setAttribute("user", user);
		req.setAttribute("users", list);
		req.setAttribute("begin", begin);
		req.setAttribute("end", end);
		// /JSP02/WEB-INF/hello.jsp
		// /JSP02/hello
		String url = "WEB-INF/hello.jsp";
		req.getRequestDispatcher(url)
			.forward(req, res);
	}

	
	
}




