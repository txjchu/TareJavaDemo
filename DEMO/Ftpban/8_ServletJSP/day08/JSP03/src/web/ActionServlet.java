package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet {

	//打开登录页：/JSP03/login/toLogin.do
	//登录：/JSP03/login/login.do
	//打开首页：/JSP03/main/toIndex.do
	//登录页：/WEB-INF/login.jsp
	//首页：/WEB-INF/index.jsp
	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType(
			"text/html;charset=utf-8");
		String uri = req.getRequestURI();
		uri = uri.replace(
			req.getContextPath(), "");
		if(uri.equals("/login/toLogin.do")) {
			//打开登录页
			toLogin(req, res);
		} else if (uri.equals("/login/login.do")) {
			//登录
			login(req, res);
		} else if (uri.equals("/main/toIndex.do")) {
			//打开首页
			toIndex(req, res);
		}
	}

	protected void toLogin(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		req.getRequestDispatcher(
			"../WEB-INF/login.jsp").forward(req, res);
	}
	
	protected void login(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//获取表单数据
		String userName = 
			req.getParameter("userName");
		String pwd = 
			req.getParameter("pwd");
		String rmb = 
			req.getParameter("remember");
		//验证：假设验证通过了
		//记住我
		if("yes".equals(rmb)) {
			//使用cookie记录账号和记住我，
			//便于处理后续请求中的一些特殊业务。
			//首页显示账号；
			//再次打开登录页时，有默认账号；
			//创建Cookie，记录账号
			//默认只对当前路径下的资源有效：
			//JSP03/login/
			//可以手动设置其生效的路径
			Cookie c = new Cookie(
				"userName", userName);
			//设置该cookie在整个项目下都有效
			c.setPath(req.getContextPath());
			//将此Cookie发送给客户端保存
			res.addCookie(c);
			//记住我可以通过userName判断出来，
			//不用特意的记录它。
		}
		//重定向到首页
		//JSP03/login/login.do
		//JSP03/main/toIndex.do
		res.sendRedirect("../main/toIndex.do");
	}
	
	protected void toIndex(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//获取浏览器传递过来的cookie，
		//并打印出他们的内容。
		Cookie[] cs = req.getCookies();
		for(Cookie c : cs) {
			System.out.println(
				c.getName() + ":" +
				c.getValue());
		}
		
		req.getRequestDispatcher(
			"../WEB-INF/index.jsp").forward(req, res);
	}
	
	
}






