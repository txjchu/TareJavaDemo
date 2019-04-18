package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController 
implements Controller{

	public ModelAndView handleRequest(
			HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		System.out.println(
				"HelloController进行业务逻辑的处理....");
		return new ModelAndView("hello");
	}

}
