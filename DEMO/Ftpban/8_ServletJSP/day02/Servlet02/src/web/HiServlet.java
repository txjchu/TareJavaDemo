package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {

	@Override
	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res)
		throws ServletException, IOException {
		//读取请求数据包中的内容
		//1.请求行
		System.out.println(
			"请求方式:"+req.getMethod());
		System.out.println(
			"Servlet路径:"+req.getServletPath());
		System.out.println(
			"协议类型:"+req.getProtocol());
		//2.消息头(key-value)
		//getHeaderNames()返回有的key
		Enumeration e = req.getHeaderNames();
		while(e.hasMoreElements()) {
			String key = 
				e.nextElement().toString();
			//根据key取value
			String value = req.getHeader(key);
			System.out.println(key+":"+value);
		}
		//3.实体内容
		//当前请求没有传参，所以实体内容为空，无法读取。
		//4.请求路径
		System.out.println(
			"URI:"+req.getRequestURI());
		System.out.println(
			"URL:"+req.getRequestURL());
		
		//使用response对象写响应信息
		//1.状态行，自动生成，通常不用自己写
		//2.消息头，有很多属性，通常只写contentType
		//设置浏览器解码方案
		res.setContentType(
			"text/html;charset=utf-8");
		//设置服务器编码方案
		//如果设置了contentType，则
		//characterEncoding默认和它一致。
//		res.setCharacterEncoding("utf-8");
		PrintWriter w = res.getWriter();
		//3.实体内容，写本次响应所返回的数据
		w.println("<h1>你好,Servlet.</h1>");
		w.close();
	}

	
	
}



