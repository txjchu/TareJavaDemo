package org.tarena.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo2Servlet extends HttpServlet{
	public void service(
		HttpServletRequest request,
		HttpServletResponse response) throws IOException{
		//获取请求带过来的用户名
		request.setCharacterEncoding("UTF-8");
		String name = 
			request.getParameter("name");
		System.out.println("----"+name);
		//响应输出结果：可用还是不可用
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//进行数据库检测
		if("scott".equals(name)){//不可用
			out.print("用户名已被占用");
		}else{//可用
			out.print("用户名可用");
		}
		out.flush();
		out.close();
	}
}



