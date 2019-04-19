package netctoss.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import netctoss.entity.Admin;
import netctoss.exception.AdminCodeException;
import netctoss.exception.PasswordException;
import netctoss.service.LoginService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * �����������������service
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Resource(name = "loginService")
	private LoginService loginService;
	
	@RequestMapping("/toLogin.do")
	public String tologin(){
		return "login";
	}
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "index";
	}
	
	@RequestMapping("/login.do")
	public ModelAndView checkLogin(String adminCode,String pwd,HttpSession session){
//		System.out.println("adminCode:"+adminCode+"pwd:"+pwd);
		
		Admin admin = loginService.login(adminCode, pwd);
		//session��֤----��¼��ɺ󣬽�һЩ��Ϣ����session��
		session.setAttribute("admin",admin);
		
		//û�з����쳣���ض�����ҳ
		return new ModelAndView(
				new RedirectView("toIndex.do"));
	}
	
	@ExceptionHandler
	public String execute(HttpServletRequest request,Exception ex) throws Exception	{
		//Ӧ���쳣����ȷ��ʾ�û�
		if(ex instanceof AdminCodeException || ex instanceof PasswordException){
			request.setAttribute("adminCode",request.getParameter("adminCode"));
			request.setAttribute("message",ex.getMessage());
			return "login";
		}else{
			//ϵͳ�쳣������Spring����
			throw ex;
		}
	}
		
		
}








