package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			//ͨ��ServletContext��ȡԤ�õ�����(ȫ��)
			ServletContext ctx = getServletContext();
			String max = ctx.getInitParameter("maxOnline");
			System.out.println(max);
			
			//ͳ������������������
			Object count = ctx.getAttribute("count");
			if(count == null){
				//��һ������ʱ��û��count����ô�ͽ�������Ϊ1
				ctx.setAttribute("count", 1);
			}else{
				//���ǵ�һ������Ļ�����count���Ǿ�ȡ��count��+1�������û�count.
				ctx.setAttribute("count", new Integer(count.toString())+1);//count��Ҫת��
			}
			res.setContentType("text/html;charset=utf-8");
			PrintWriter w = res.getWriter();
			w.println("������Ϊ��"+ctx.getAttribute("count"));
			w.close();			
	}
	
}
