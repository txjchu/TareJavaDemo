package org.tarena.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.tarena.entity.User;

public class Demo4Servlet extends HttpServlet{
	
	public void service(
			HttpServletRequest req,HttpServletResponse res)throws IOException{
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter();
		User user = new User();
		user.setId(1);
		user.setName("ØÂÔÂ");
		JSONObject json = JSONObject.fromObject(user);
		
		out.print(json.toString());
		out.flush();
		out.close();
		//instantiate
	}
}
