package org.tare.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 	
 * @author Administrator	project工程，设计，计划	programme 计划，节目，工程 	object 目标客体宾语	frame 框架，结构
 *
 */
public class HelloController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		System.out.println("DispatcherServlet依据HandlerMapping调用了Controller组件：Hello,Controller");
		return new ModelAndView("jsp/hello");
	}
	
	
}
