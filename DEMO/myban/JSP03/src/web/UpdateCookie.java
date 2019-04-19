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
 * 修改Cookie案例
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
					//Cookie中只能保存阿斯克码，保存中文必须编码
					String str = URLEncoder.encode("西安","UTF-8");
					//修改cookie，同样还是用setValue方法，用来覆盖Cookie
					c.setValue(str);
				}
				//解码中文
				String value = URLDecoder.decode(c.getValue(), "utf-8");
				out.println("name:"+ name +",value:"+ value +"<br/>");
			}
		}
		out.close();
		
		
		
	}
	
}
