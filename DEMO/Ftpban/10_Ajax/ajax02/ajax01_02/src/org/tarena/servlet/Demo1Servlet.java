package org.tarena.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo1Servlet extends HttpServlet{
	
	public void service(
		HttpServletRequest request,
		HttpServletResponse response) throws IOException{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//���������Ƿ����
		System.out.println("----����Demo1Servlet------");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("Ajax���");
		out.flush();
		out.close();
	}
	
}
