package netctoss.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import netctoss.entity.Admin;
import netctoss.service.ApplicationException;
import netctoss.service.LoginService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {
	private LoginService loginService;
	
	public LoginService getLoginService() {
		return loginService;
	}
	@Resource(name="loginService")
	public void setLoginService(LoginService loginService) {
		System.out.println(
				"ע��loginService:" + loginService);
		this.loginService = loginService;
	}

	@RequestMapping("/toLogin.do")
	public String tologin(){
		return "login";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "index";
	}
	
	@ExceptionHandler
	public String execute(HttpServletRequest request,
			Exception ex) throws Exception{
		//Ӧ���쳣����ȷ��ʾ�û�
		if(ex instanceof ApplicationException){
			request.setAttribute("adminCode", 
					request.getParameter("adminCode"));
			request.setAttribute("message", 
					ex.getMessage());
			return "login";
		}else{
			//ϵͳ�쳣������spring����
			throw ex;
		}
		
	}
	
	@RequestMapping("/login.do")
	public ModelAndView checkLogin(
			String adminCode,String pwd,
			HttpSession session){
		System.out.println(
				"adminCode:" 
				+ adminCode + " pwd:" + pwd);
		Admin admin = 
				loginService.login(adminCode, pwd);
		session.setAttribute("admin", admin);
		//��¼�ɹ�,�ض�����ҳ
		return new ModelAndView(
				new RedirectView("toIndex.do"));
	}
}
