package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 验证码图片的生成与发送
 * @author Administrator
 *
 */
public class ValidateCode extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
//		PrintWriter out = res.getWriter();------getWriter()和getOutputStream()方法互斥，调用一个，就不能调用另一个了。
		
		String uri = req.getRequestURI();//获取的是资源路径  uri:/JSP04/login/code1
//		StringBuffer url = req.getRequestURL();//获取的是绝对地址  url:http://localhost:9080/JSP04/login/code1
//		System.out.println("uri:"+ uri +"\n"+ "url:"+ url);
		String action = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
		System.out.println("action:"+ action);
		String code ;//用来储存生成图片后session中的value
		
		if(action.equals("test")){
//			res.sendRedirect("aaa.jsp");//不能重定向，因为若是验证码输入错误，需要转发回验证页面
			req.getRequestDispatcher("aaa.jsp").forward(req, res);
			
		} else if(action.equals("code1")){
//			System.out.println("走没走调用验证码图片的方法呢？");
			validate(req, res);//调用生成验证图片方法
		} else if(action.equals("check")){
			/*
			 * 验证：验证码是否输入正确，正确-->ccc.jsp；不正确-->转发回当前页面，并给出提示。
			 */
			//表单提交后先验证验证码是否输入正确：正确-->重定向ccc.jsp；不正确--转发回当前页面，并显示提示
			HttpSession session = req.getSession();
			code = (String) session.getAttribute("code");
			String vcode = req.getParameter("vcode");
			System.out.println("code:"+ code +";vcode:"+ vcode);
			if(vcode.toUpperCase().equals(code)){//若验证码输入正确
				toCCC(req, res);
			} else {
				req.setAttribute("msg", "验证码输入错误");
				System.out.println("此处给req设置msg"+ req.getAttribute("msg"));
				req.getRequestDispatcher("test.dd").forward(req, res);//转发回当前
			}			
		} else if(action.equals("ccc")){//验证成功
			res.sendRedirect("main/ccc.jsp");
		}
		
		
	}
	//验证成功进入ccc页面的方法，使用重定向，掩盖ccc的真实路径
	protected void toCCC(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		String url = res.encodeRedirectURL("main/ccc.dd");
//		res.sendRedirect(url);//重定向	
		req.getRequestDispatcher("WEB-INF/ccc.jsp").forward(req, res);//此处WEB-INF/ccc.jsp和/WEB-INF/ccc.jsp都可以
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
		String number = getNumber(4);
//		System.out.println("自定义方法生成的随机字符串:"+ number);
		
		HttpSession session = req.getSession();//将验证码字符串放入session中
		
		session.setAttribute("code", number);
		g.setColor(new Color(0, 0, 0));//设置字符的颜色
		g.setFont(new Font(null,Font.BOLD,24));//设置字体，字号
		g.drawString(number, 5, 25);//画出字符串，后两个参数是xy的坐标
		//6.画出干扰线
		for(int i = 0; i < 8; i ++){
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
		}
		//7.压缩图片并输出
		res.setContentType("image/jpeg");
		OutputStream os = res.getOutputStream();//字节输出流
//		System.out.println("走了验证码方法");
		ImageIO.write(image, "jpeg", os);
		os.close();
		
		
	}
	//获取指定长度的随机字符串
	protected String getNumber(int size){
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String number = "";
		Random r = new Random();
		for(int i = 0; i < size; i ++){
			number += str.charAt(r.nextInt(str.length()));//随机生成一个下标，获取该下标所在的字符，拼接
		}
		return number;
	}
	
}
