package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �޸�Cookie����
 * @author Administrator
 *
 */
public class UpdateCookie extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(Cookie c : cookies){
				String name = c.getName();
				if(name.equals("city")){
					//Cookie��ֻ�ܱ��氢˹���룬�������ı������
					String str = URLEncoder.encode("����","UTF-8");
					//�޸�cookie��ͬ��������setValue��������������Cookie
					c.setValue(str);
				}
				//��������
				String value = URLDecoder.decode(c.getValue(), "utf-8");
				out.println("name:"+ name +",value:"+ value +"<br/>");
			}
		}
		out.close();
		
		
		
	}
	
}
