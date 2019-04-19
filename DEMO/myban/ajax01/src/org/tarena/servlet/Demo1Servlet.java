package org.tarena.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo1Servlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//测试是否进入
		System.out.println("--ok--");
		res.setContentType("text/html;charset=UTF-8");	//如果字符串写错，浏览器会提示另存为再打开。认为有危险
		PrintWriter out = res.getWriter();
		out.print("Ajax你好");
		out.flush();
		out.close();
	}
}
