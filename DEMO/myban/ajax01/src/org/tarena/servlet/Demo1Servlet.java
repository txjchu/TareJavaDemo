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
		//�����Ƿ����
		System.out.println("--ok--");
		res.setContentType("text/html;charset=UTF-8");	//����ַ���д�����������ʾ���Ϊ�ٴ򿪡���Ϊ��Σ��
		PrintWriter out = res.getWriter();
		out.print("Ajax���");
		out.flush();
		out.close();
	}
}
