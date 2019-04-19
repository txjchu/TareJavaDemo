package org.tarena.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import net.sf.json.JSONArray;

import org.tarena.entity.User;

public class Demo6Servlet extends HttpServlet {
	public void service(
			HttpServletRequest req,HttpServletResponse res)throws IOException{
	
		
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter();
		//构建List<User>
		List<User> list = new ArrayList<User>();
		
		User user = new User();
		user.setId(1);
		user.setName("芈月1");
		
		User user1 = new User();
		user1.setId(2);
		user1.setName("小倩1");
		list.add(user);
		list.add(user1);
		
		JSONArray json = JSONArray.fromObject(list);
		//输出
		out.println(json);
		System.out.println(json);
		
		out.flush();
		out.close();
		
		
		/*
		PrintWriter out = res.getWriter();
		List<User1> list1 = new ArrayList<User1>();
		User1 user3 = new User1();
		user3.setId(3);
		user3.setName("唐僧");
		
		User1 user4 = new User1();
		user4.setId(4);
		user4.setName("八戒");
		
		list1.add(user3);
		list1.add(user4);
		
		JSONArray json = JSONArray.fromObject(list1);
		
		out.print(json);
		out.flush();
		out.close();
		*/
		
	}
}
