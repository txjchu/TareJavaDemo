package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����������cookie�ı���ʱ��		Persistent ��ִ�ĳ־õ�
 * @author Administrator
 *
 */
public class PersistentCookie extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		Cookie[] cookies = req.getCookies();
		cookies[0].setMaxAge(100);
		cookies[1].setMaxAge(Integer.MAX_VALUE);//����Ϊ������Ч
		out.print("�޸�cookieʱ����ɣ�<br/>");
		out.print("name:"+ cookies[0].getName() +",ʱ�䣺"+cookies[0].getMaxAge() +"<br/>");
		out.print("name:"+ cookies[1].getName() +",ʱ�䣺"+cookies[1].getMaxAge() +"<br/>");
		out.close();
		
		
		
	}
	
}
