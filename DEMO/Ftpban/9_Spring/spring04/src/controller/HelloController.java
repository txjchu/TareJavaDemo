package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hellodemo")
public class HelloController {
	/**
	 * 方法名称可以自定义，返回值
	 * 可以是字符串(视图名)，也可以是
	 * ModelAndView。
	 */
	@RequestMapping("/hello.do")
	public String hello1(){
		System.out.println("hello1方法...");
		return "hello";
	}
	
	/**
	 * 在Controller类里面，可以添加多个处理
	 * 方法。
	 */
	@RequestMapping("/hello2.do")
	public ModelAndView hello2(){
		System.out.println("hello2方法...");
		return new ModelAndView("hello");
	}
	
	
}
