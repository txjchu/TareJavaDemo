package com.tare.web;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 案例2：练习spring中异常的处理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/demo")
public class HelloController implements Serializable{
	
	//练习拦截器的使用
	@RequestMapping("/nihao.do")
	public String nihao(){
		System.out.println("你好...");
		return "jsp/hello";
	}
	
	//使用@ExceptionHandler注解处理异常
	@ExceptionHandler
	public String handleException(Exception e, HttpServletRequest req, HttpServletResponse res) throws Exception{
		if(e instanceof NumberFormatException){
			//1.处理业务异常
			req.setAttribute("message", "亲，请输入数字哦，否则转换出异常");
//			return "redirect:index.jsp";	//此处不能使用重定向，重定向为重新发送新的请求路径，并不是直接重定向到指定的页面。
			return "jsp/message";
		} else {
			//2.将系统异常继续抛出，交给SimpleExceptionResolver处理
			throw e;
		}	
	}

	@RequestMapping("/hi.do")
	public String hi(){
		System.out.println("hi....");
		Integer.valueOf("abc");
		
		return "jsp/hello";
	}
	
	@RequestMapping("/hello")
	public String hello(){
		System.out.println("hello...");
		Integer.valueOf("abc");//使程序抛出一个异常
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("捕获一个异常，springMVC容器的异常处理器还会起作用吗?");//不会再起作用了，此处已经处理了该异常。
		}
		return "jsp/hello";//转发到hello界面。
	}
	
}









