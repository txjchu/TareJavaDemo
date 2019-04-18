package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@ExceptionHandler
	public String execute(
			HttpServletRequest request,
			Exception ex) throws Exception{
		//应用异常，明确提示用户
		if(ex instanceof NumberFormatException){
			request.setAttribute("msg", 
					"请输入正确的数字");
			return "message";
		}else{
			//系统异常，告诉用户稍后重试
			throw ex;
		}
		//系统异常，告诉用户稍后重试
//		return "error";
	}
	@RequestMapping("/hello1.do")
	public String hello1(){
		System.out.println("hello1方法...");
		Integer.parseInt("abc");
		return "hello";
	}
	
	@RequestMapping("/hello2.do")
	public String hello2(){
		System.out.println("hello2方法...");
		"abcdefg".charAt(20);
		return "hello";
	}
}
