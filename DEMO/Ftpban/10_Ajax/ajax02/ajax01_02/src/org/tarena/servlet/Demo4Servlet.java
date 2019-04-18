package org.tarena.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.tarena.entity.User;

public class Demo4Servlet extends HttpServlet{
	
	//��JSON��ʽ���һ��User������Ϣ
	public void service(
		HttpServletRequest request,
		HttpServletResponse response) throws IOException{
		
		response.setContentType(
				"text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//��user����ת��json�ַ���
		User user = new User();
		user.setId(1);
		user.setName("����");
		JSONObject json = JSONObject.fromObject(user);
		//���
		out.print(json);
		out.flush();
		out.close();
	}
}


