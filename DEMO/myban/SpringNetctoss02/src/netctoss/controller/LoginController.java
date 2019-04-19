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
 * 二级控制器，会调用service
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
		//session验证----登录完成后，将一些信息放在session里
		session.setAttribute("admin",admin);
		
		//没有发生异常，重定向到首页
		return new ModelAndView(
				new RedirectView("toIndex.do"));
	}
	
	@ExceptionHandler
	public String execute(HttpServletRequest request,Exception ex) throws Exception	{
		//应用异常，明确提示用户
		if(ex instanceof AdminCodeException || ex instanceof PasswordException){
			request.setAttribute("adminCode",request.getParameter("adminCode"));
			request.setAttribute("message",ex.getMessage());
			return "login";
		}else{
			//系统异常，交给Spring处理
			throw ex;
		}
	}
		
		
}








