package com.tare.web;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ����2����ϰspring���쳣�Ĵ���
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/demo")
public class HelloController implements Serializable{
	
	//��ϰ��������ʹ��
	@RequestMapping("/nihao.do")
	public String nihao(){
		System.out.println("���...");
		return "jsp/hello";
	}
	
	//ʹ��@ExceptionHandlerע�⴦���쳣
	@ExceptionHandler
	public String handleException(Exception e, HttpServletRequest req, HttpServletResponse res) throws Exception{
		if(e instanceof NumberFormatException){
			//1.����ҵ���쳣
			req.setAttribute("message", "�ף�����������Ŷ������ת�����쳣");
//			return "redirect:index.jsp";	//�˴�����ʹ���ض����ض���Ϊ���·����µ�����·����������ֱ���ض���ָ����ҳ�档
			return "jsp/message";
		} else {
			//2.��ϵͳ�쳣�����׳�������SimpleExceptionResolver����
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
		Integer.valueOf("abc");//ʹ�����׳�һ���쳣
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("����һ���쳣��springMVC�������쳣������������������?");//�������������ˣ��˴��Ѿ������˸��쳣��
		}
		return "jsp/hello";//ת����hello���档
	}
	
}









