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
		//��ȡ������������û���
		request.setCharacterEncoding("UTF-8");
		String name = 
			request.getParameter("name");
		System.out.println("----"+name);
		//��Ӧ�����������û��ǲ�����
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//�������ݿ���
		if("scott".equals(name)){//������
			out.print("�û����ѱ�ռ��");
		}else{//����
			out.print("�û�������");
		}
		out.flush();
		out.close();
	}
}



