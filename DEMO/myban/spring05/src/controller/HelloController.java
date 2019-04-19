package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 二级控制器
 * @author Administrator
 *
 */
@Controller
public class HelloController {
	
	@ExceptionHandler
	public String execute(HttpServletRequest request,Exception ex){
		//应用异常，明确提示用户
		if(ex instanceof NumberFormatException){
			request.setAttribute("msg", "请输入正确的数字");
			return "message";
		}	
		//系统异常，告诉用户稍后重试
		return "error";
	}
	
	@RequestMapping("/hello1.do")
	public String hello1(){
		System.out.println("hello1方法....");
		Integer.parseInt("abc");//--会出运行异常。
		return "hello";			//--视图名
	}
	@RequestMapping("/hello2.do")
	public String hello2(){
		System.out.println("hello2方法...");
		"abcdefg".charAt(20);	//--会出越界异常
		return "hello";
	}
}
