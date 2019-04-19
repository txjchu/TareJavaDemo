package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		System.out.println("HelloController进行了业务逻辑的处理...(以后可以调用一个dao，查询数据库)");
		return new ModelAndView("hello");	//不加.jsp，可以更加灵活的展现最终的View
	}

}
