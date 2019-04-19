package org.tare.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ע�ⷽʽ��ϰSpringMVC
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/demo")	//����·����Ӧ������ʼ�ľ���·�����˴�ע����˼�Ǹ�Controller������"/demo"��ͷ���������
public class HelloController {
	public HelloController(){
		System.out.println("��ʼ����Controller");
	}
	@RequestMapping("/hello.do")//�˴�ע����˼Ϊ�÷�������"/demo/hello.do"Ϊ·��������
	public ModelAndView hello(HttpServletRequest req, HttpServletResponse res) throws Exception{
		System.out.println("ִ��Controller�е�hello����...");
		return new ModelAndView("hello");//����ֵ����viewҳ����������WEB-INF�µ�jspҳ����
	}
	
	//PPT����������		��������ʹ��@RequestMappingע��	standard��׼	
	@RequestMapping("/hello1.do")
	public String execute(){
		System.out.println("ִ��Controller�е�execute����...");
		return "hello1";
	}
}
