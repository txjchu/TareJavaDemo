package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = req.getSession(); 
		
		String uri = req.getRequestURI();
//		System.out.println("uri:"+ uri);//当前uri
//		System.out.println("请求的ContextPath:"+ req.getContextPath());//请求的上下文路径
		uri = uri.replace(req.getContextPath(),"");//----获取当前请求的简化uri
		if(uri.equals("/login/toLogin.do")){
			//打开登录页
			toLogin(req,res);
		}else if(uri.equals("/login/login.do")){
			//登录
			login(req,res);
		}else if(uri.equals("/main/toIndex.do")){
			//打开首页
			toIndex(req,res);
		} else if(uri.equals("/main/logout.do")){
			session.invalidate();//使无效。清空session中的设置
			res.sendRedirect("/JSP04/login/toLogin.do");//重定向会登录页面
		} else if (uri.equals("/login/code.do")){
			//获取验证码图片
			validate(req, res);
		}
	}
	
	//获取验证图片的方法
	protected void validate(HttpServletRequest req, HttpServletResponse res) throws IOException{
		Random r = new Random(); 
		//1.创建画板对象
		BufferedImage image = new BufferedImage(100,30, BufferedImage.TYPE_INT_RGB);
		//2.创建画笔对象
		Graphics g = image.getGraphics();
		//3.设定画笔颜色
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		//4.绘制矩形背景
		g.fillRect(0, 0, 100, 30);
		//5.调用自定义的方法获取长度为5的字符串，即生成的验证码包含5个字符
		String str = getNumber(5);
		HttpSession session = req.getSession();//获取当前session对象
		session.setAttribute("code", str);//将验证码字符串放入session中
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));//设置字符串的颜色
		g.setFont(new Font(null, Font.BOLD, 24));//设置字体字号
		g.drawString(str, 5, 25);//画出字符串，后两个参数是xy的坐标
		//6.画出干扰线
		for(int i = 0; i < 8; i ++){
            g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
		}
		//7.压缩图片并输出
		res.setContentType("image/jpeg");
		OutputStream os = res.getOutputStream();//字节输出流
		ImageIO.write(image, "jpeg", os);
		os.close();
	}
	//获取随机生成指定长度的字符串方法
	protected String getNumber(int size){
		String str ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String number = "";
		Random r = new Random();
		for(int i = 0; i < size; i++){
			number += str.charAt(r.nextInt(str.length()));//随机生成一个下标，然后获取字符串中该下标多代表的字符，并不断拼接
		}
		return number;
	}
	
	//转去登录页面
	protected void toLogin(HttpServletRequest req, HttpServletResponse res)
									throws ServletException, IOException {
		req.getRequestDispatcher("../WEB-INF/login.jsp").forward(req, res);
	}
	//登录页面
	protected void login(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		//获取表单数据
		String userName = req.getParameter("userName");
		String pwd = req.getParameter("pwd");
		String rmb = req.getParameter("remember");
		String vcode = req.getParameter("vcode").toUpperCase();//获取验证码输入框中输入的字符串
		HttpSession session = req.getSession();//获取当前session对象
		String code = (String) session.getAttribute("code");//从session中取得vcode的value
		//验证：校验账号，密码，验证码
		if(userName.equals("zhang") && pwd.equals("123456") && vcode.equals(code)){
			//记住我
			//如果勾选了复选框，就是记住我，----【yes和rmb位置，这样写避免空指针异常】
			if("yes".equals(rmb)){
				/*
				 * 该页面的session只有在选中了submit提交框的yes后，才会给session设置属性userName.
				 * 后续首页验证时才能获取到。（xml中配置了session的保存时间为1分钟。）
				 */
				//获取session,此session在Tomcat创建request之前就自动创建了。
				//session只在此一次请求时创建一次。
				session = req.getSession();
				//向session中存数据。
				session.setAttribute("userName",userName);
			}
			
			//当前：/JSP03/login/login.do
			//目标：/JSP03/main/toindex.do
			//若正确则重定向到首页
			//此处使用重写url，防止浏览器关闭cookie，将sessionID追加到url======此处没有重写url
			String url = res.encodeRedirectURL("../main/toIndex.do");
//			System.out.println("login()方法的重写后的url:"+ url);
			res.sendRedirect(url);//重定向
		} else {//若账号或密码不正确
			//response中不能设置属性和参数。
			//信息
			req.setAttribute("msg", "用户名或密码不正确！");
			/*
			 * 登录页面怎么获取账号密码输错后的反馈结果？
			 * 使用转发回登录页面。
			 * 因为重定向是浏览器发送2次请求，转发是同一个请求，因此，此处给该请求对象设置了属性，但是如果用了重定向，
			 * 则该请求对象被销毁，重新创建了新的请求对象。因此，页面中的获取请求对象中的属性的代码只能获取到Null。
			 * 
			 */
//			System.out.println("toLogin()方法中设置的req中的键值对"+ req.getAttribute("msg"));
			//重定向：重新回到登录页面
//			res.sendRedirect("/JSP04/login/toLogin.do");
			req.getRequestDispatcher("/login/toLogin.do").forward(req, res);
			
		}
		
		
	}
	//打开首页
	protected void toIndex(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		HttpSession session = req.getSession();
		//从Session中读取数据。
		String userName = (String)session.getAttribute("userName");
		System.out.println("toIndex()方法输出的此时从session中获取的信息userName："+ userName);
		
		//转发
		String url = res.encodeRedirectURL("../WEB-INF/index.jsp");
		req.getRequestDispatcher(url).forward(req, res);
	}
	
	
}
