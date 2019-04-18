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
	
	//��JSON��ʽ������User������Ϣ
	public void service(
		HttpServletRequest request,
		HttpServletResponse response) throws IOException{
		
		response.setContentType(
				"text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//����List<User>
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setId(1);
		user.setName("����");
		User user1 = new User();
		user1.setId(2);
		user1.setName("Сٻ");
		list.add(user);//���user
		list.add(user1);//���user1
		
		JSONArray json = JSONArray.fromObject(list);
		//���
		out.print(json);
		out.flush();
		out.close();
	}
}


