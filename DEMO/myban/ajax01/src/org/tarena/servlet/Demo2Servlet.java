package org.tarena.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo2Servlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException{
		//��ȡ������������û���
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");	//----��������key
		System.out.println("----"+name+"----");
		//��Ӧ�����������û��ǲ�����
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		//�������ݿ���
		if("scott".equals(name)){//������
			out.println("�û����ѱ�ռ��");
		}else{//����
			out.println("�û�������");
		}
		out.flush();
		out.close();
		
		
	}
}
