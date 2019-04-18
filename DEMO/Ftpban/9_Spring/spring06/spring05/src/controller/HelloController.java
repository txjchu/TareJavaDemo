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
		//Ӧ���쳣����ȷ��ʾ�û�
		if(ex instanceof NumberFormatException){
			request.setAttribute("msg", 
					"��������ȷ������");
			return "message";
		}else{
			//ϵͳ�쳣�������û��Ժ�����
			throw ex;
		}
		//ϵͳ�쳣�������û��Ժ�����
//		return "error";
	}
	@RequestMapping("/hello1.do")
	public String hello1(){
		System.out.println("hello1����...");
		Integer.parseInt("abc");
		return "hello";
	}
	
	@RequestMapping("/hello2.do")
	public String hello2(){
		System.out.println("hello2����...");
		"abcdefg".charAt(20);
		return "hello";
	}
}
