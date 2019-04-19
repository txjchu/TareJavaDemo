package org.tare.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 注解方式练习SpringMVC
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/demo")	//请求路径从应用名后开始的绝对路径，此处注解意思是该Controller处理以"/demo"开头的请求对象
public class HelloController {
	public HelloController(){
		System.out.println("初始化了Controller");
	}
	@RequestMapping("/hello.do")//此处注解意思为该方法处理"/demo/hello.do"为路径的请求
	public ModelAndView hello(HttpServletRequest req, HttpServletResponse res) throws Exception{
		System.out.println("执行Controller中的hello方法...");
		return new ModelAndView("hello");//返回值包含view页面名，即在WEB-INF下的jsp页面名
	}
	
	//PPT中这样举例		可以这样使用@RequestMapping注解	standard标准	
	@RequestMapping("/hello1.do")
	public String execute(){
		System.out.println("执行Controller中的execute方法...");
		return "hello1";
	}
}
