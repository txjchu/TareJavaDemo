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
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//初始化一些数据
		User user = new User();
		user.setUserName("cang");
		user.setPassword("123");
		user.setSex("Male");
		user.setLoves(new String[]{"摄影","表演"});
		Course c = new Course();
		c.setId(1);
		c.setName("Java");
		c.setDays(85);
		user.setCourse(c);
		
		//创建一个要遍历的实体集合对象
		List<User> list = new ArrayList<User>();
		User u1 = new User();
		u1.setUserName("苍老师");
		list.add(u1);
		
		User u2 = new User();
		u2.setUserName("范传奇");
		list.add(u2);
		
		User u3 = new User();
		u3.setUserName("王克静");
		list.add(u3);
		
		//要遍历的起点和终点----可以指定为动态的。
		int begin = 0;
		int end = 1;
		
		//将数据转发给hello.jsp----转发之前串数据
		req.setAttribute("user", user);
		req.setAttribute("users", list);	//----传入数组
		req.setAttribute("begin",begin);	//----传入起点和终点的两个数据
		req.setAttribute("end", end);	
		
		
		//项目路径：/JSP02/WEB-INF/hello.jsp
		//假设当前Servlet访问路径：/JSD02/hello
		String url = "WEB-INF/hello.jsp";	//----平级可以这样写
		
		//   调用forward()方法实现转发。
		req.getRequestDispatcher(url).forward(req, res);
	}
	
}
