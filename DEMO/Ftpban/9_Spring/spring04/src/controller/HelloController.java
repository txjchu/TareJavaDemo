package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hellodemo")
public class HelloController {
	/**
	 * �������ƿ����Զ��壬����ֵ
	 * �������ַ���(��ͼ��)��Ҳ������
	 * ModelAndView��
	 */
	@RequestMapping("/hello.do")
	public String hello1(){
		System.out.println("hello1����...");
		return "hello";
	}
	
	/**
	 * ��Controller�����棬������Ӷ������
	 * ������
	 */
	@RequestMapping("/hello2.do")
	public ModelAndView hello2(){
		System.out.println("hello2����...");
		return new ModelAndView("hello");
	}
	
	
}
