package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		System.out.println("HelloController������ҵ���߼��Ĵ���...(�Ժ���Ե���һ��dao����ѯ���ݿ�)");
		return new ModelAndView("hello");	//����.jsp�����Ը�������չ�����յ�View
	}

}
