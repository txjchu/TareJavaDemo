package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {
	//复写servlet方法
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		//读取请求数据包中的内容
		//1.------3个请求行中的内容
		System.out.println("请求方式："+req.getMethod());
		System.out.println("Servlet路径："+req.getServletPath());
		System.out.println("协议类型"+req.getProtocol());		//----HTTP协议的版本
		
		//2.消息头(key-value)
		//getHeaderNames()返回所有的key
		Enumeration e = req.getHeaderNames();
		while(e.hasMoreElements()){
			String key = e.nextElement().toString();
			//根据key获取value
			String value = req.getHeader(key);
			System.out.println(key+":"+value);
		}
		//3.URI：请求资源路径，当前请求没有传送参数，所以实体内容为空。
		//4.URL：请求路径信息
		System.out.println("URI:"+req.getRequestURI());	//----请求资源路径----(资源的名称)URI:/Servlet02/hi------(苍老师，刘老师...)
		System.out.println("URL:"+req.getRequestURL());	//----请求路径信息----(资源的真实名称)URL:http://localhost:9080/Servlet02/hi(刘苍松)
		
		//使用response对象写响应信息
		//1.状态行，自动生成，通常不用自己写，
		//2.消息头，有很多属性，通常只写contentType，
		
				//设置浏览器解码方案
		res.setContentType("text/html;charset = utf-8");	//charset设置浏览器装包编码方案
		
				//设置浏览器编码方法，----如果设置了contentType,则characterEncoding默认和它一致。
		res.setCharacterEncoding("utf-8");			//----设置了contentType,就可以不设置该属性
		
		PrintWriter w = res.getWriter();
		//3.实体内容，写本次响应所返回的数据。
		w.println("<h1>Hi你好,Servlet!<h1>");
		w.close();
		//在web.xml里注册
	}

}
