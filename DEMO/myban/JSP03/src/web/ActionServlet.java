package web;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {
	//打开登录页面：/JSP03/login/toLogin.do
	//登录：/JSP03/login/login.do	
	//打开首页：/JSP03/main/toIndex.do
	//登录页：/WEB-INF/login.jsp
	//首页：/WEB-INF/index.jsp
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		String uri = req.getRequestURI();
		uri = uri.replace(req.getContextPath(),"");//----简化uri
		if(uri.equals("/login/toLogin.do")){
			//打开登录页
			toLogin(req,res);
		}else if(uri.equals("/login/login.do")){
			//登录
			login(req,res);
		}else if(uri.equals("/main/toIndex.do")){
			//打开首页
			toIndex(req,res);
		}
	}
	protected void toLogin(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		req.getRequestDispatcher("../WEB-INF/login.jsp").forward(req, res);
	}
	
	protected void login(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		//获取表单数据
		String userName = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		String rmb = req.getParameter("remember");
		//验证：假设验证通过了
		//记住我
		//如果勾选了复选框，就是记住我，----【yes和rmb位置，这样写避免空指针异常】
		if("yes".equals(rmb)){
			//使用cookie记录账号和记住我
			//便于处理后续请求中的一些特殊业务：如首页显示账号；再次打开登录页时有默认账号；
			
			Cookie c = new Cookie("userName",userName);//创建Cookie，记录账号。
			//默认只对当前路径下的资源有效：/JSP03/login/     可以手动设置其生效的路径。
			c.setPath(req.getContextPath());	
			
			//默认情况下，cookie存到浏览器内容中，浏览器关闭则cookie消失。
			//若希望浏览器关闭时cookie不消失，需要给这个cookie设置过期时间，那么cookie在关闭浏览器后还能存和这么长的时间。
			c.setMaxAge(3600);
			
			
			//将此Cookie发送给客户端保存
			res.addCookie(c);
			//记住我，可以通过userName判断出来，不用特意的记录它。			
		}
		Cookie c2 = new Cookie("city","BeiJing");
		c2.setPath(req.getContextPath());//----设置路径，只要是这个项目下都可以使用这个cookie
		c2.setMaxAge(3600);
		res.addCookie(c2);//-----传给客户端
		
		Cookie c3 = new Cookie("home",URLEncoder.encode("上海","utf-8"));//如果写入中文，则需要使用URLEncoder.
		c3.setPath(req.getContextPath());
		c3.setMaxAge(3600);
		res.addCookie(c3);
		
		//重定向到首页
		//当前：/JSP03/login/login.do
		//目标：/JSP03/main/toindex.do
		res.sendRedirect("../main/toIndex.do");
		
	}
	//打开首页
	protected void toIndex(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		//获取浏览器传递过来的cookie，并打印出它们的内容。
		Cookie[] cs = req.getCookies();
		for(Cookie c:cs){
			//修改cookie
			if(c.getName().equals("city")){
				c.setValue("ShenZhen");
				res.addCookie(c);
			}
			if(c.getName().equals("home")){
				System.out.println(URLDecoder.decode(c.getValue(),"utf-8"));
			}else{	
			//获取，并输出
			System.out.println(c.getName()+":"+c.getValue());
			}
		}
		//转发
		req.getRequestDispatcher("../WEB-INF/index.jsp").forward(req, res);
	}
}
