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
		
		//Ҫ�����ļ���
		List<User> list = new ArrayList<User>();
		User u1 = new User();
		u1.setUserName("����ʦ");
		list.add(u1);
		User u2 = new User();
		u2.setUserName("������");
		list.add(u2);
		User u3 = new User();
		u3.setUserName("���˾�");
		list.add(u3);
		
		//Ҫ�����������յ�
		int begin = 6;
		int end = 10;
		
		//������ת����hello.jsp
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




