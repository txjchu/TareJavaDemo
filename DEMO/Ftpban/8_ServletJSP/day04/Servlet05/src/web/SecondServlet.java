package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//ͨ��ServletContext��ȡԤ�õ�����(ȫ��)
		ServletContext ctx = getServletContext();
		String max = 
			ctx.getInitParameter("maxOnline");
		System.out.println(max);
		
		//ͳ������������������
		Object count = ctx.getAttribute("count");
		if(count == null) {
			//��һ������ʱû��count��
			//���ǽ�������Ϊ1��
			ctx.setAttribute("count", 1);
		} else {
			//���ǵ�һ������ʱ��count��
			//ȡ��count��+1��������count��
			ctx.setAttribute("count", 
				new Integer(count.toString())+1);
		}
		
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter w = res.getWriter();
		w.println("������Ϊ��" 
			+ ctx.getAttribute("count"));
		w.close();		
	}

	
}




