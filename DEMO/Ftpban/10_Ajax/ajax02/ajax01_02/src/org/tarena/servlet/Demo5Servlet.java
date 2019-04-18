package org.tarena.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.tarena.entity.User;

public class Demo5Servlet extends HttpServlet{
	
	//以JSON格式输出多个User对象信息
	public void service(
		HttpServletRequest request,
		HttpServletResponse response) throws IOException{
		
		response.setContentType(
				"text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//构建List<User>
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setId(1);
		user.setName("芈月");
		User user1 = new User();
		user1.setId(2);
		user1.setName("小倩");
		list.add(user);//添加user
		list.add(user1);//添加user1
		
		JSONArray json = JSONArray.fromObject(list);
		//输出
		out.print(json);
		out.flush();
		out.close();
	}
}


