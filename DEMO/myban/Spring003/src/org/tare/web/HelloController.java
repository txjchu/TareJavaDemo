package org.tare.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 	
 * @author Administrator	project���̣���ƣ��ƻ�	programme �ƻ�����Ŀ������ 	object Ŀ��������	frame ��ܣ��ṹ
 *
 */
public class HelloController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		System.out.println("DispatcherServlet����HandlerMapping������Controller�����Hello,Controller");
		return new ModelAndView("jsp/hello");
	}
	
	
}
