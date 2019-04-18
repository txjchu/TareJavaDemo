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
				"注入loginService:" + loginService);
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
		//应用异常，明确提示用户
		if(ex instanceof ApplicationException){
			request.setAttribute("adminCode", 
					request.getParameter("adminCode"));
			request.setAttribute("message", 
					ex.getMessage());
			return "login";
		}else{
			//系统异常，交给spring处理
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
		//登录成功,重定向到首页
		return new ModelAndView(
				new RedirectView("toIndex.do"));
	}
}
