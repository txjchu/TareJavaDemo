package org.tarena.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.tarena.entity.User;

public class Demo4Servlet extends HttpServlet{
	
	//以JSON格式输出一个User对象信息
	public void service(
		HttpServletRequest request,
		HttpServletResponse response) throws IOException{
		
		response.setContentType(
				"text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//将user对象转成json字符串
		User user = new User();
		user.setId(1);
		user.setName("芈月");
		JSONObject json = JSONObject.fromObject(user);
		//输出
		out.print(json);
		out.flush();
		out.close();
	}
}


