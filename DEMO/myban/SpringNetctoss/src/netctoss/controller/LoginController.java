package netctoss.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import netctoss.entity.Admin;
import netctoss.service.ApplicationException;
import netctoss.service.LoginService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 二级控制器，会调用service
 * @author Administrator
 *
 */
@Controller
public class LoginController {
	private LoginService loginService;
	
	public LoginService getLoginService() {
		return loginService;
	}
	@Resource(name="loginService")
	public void setLoginService(LoginService loginService) {
		System.out.println("注入loginService:"+loginService);
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
	@RequestMapping("/login.do")
	public ModelAndView checkLogin(String adminCode,String pwd,HttpSession session){
		System.out.println("adminCode:"+adminCode+"pwd:"+pwd);
		
		try {
			Admin admin = loginService.login(adminCode, pwd);
			//session验证----登录完成后，将一些信息放在session里
			session.setAttribute("admin",admin);
		} catch (Exception e) {
			e.printStackTrace();
			if(e instanceof ApplicationException){
				//应用异常，要明确提示用户原因
				Map<String,String> data = new HashMap<String,String>();
				data.put("adminCode", adminCode);			//--设置返回后账号默认上次输入的。
				data.put("message", e.getMessage());
				return new ModelAndView("login",data);		//--转发到登录页面
			}
				//系统异常，提示用户稍后重试
				return new ModelAndView("error");			
		}
		//没有发生异常，重定向到首页
		return new ModelAndView(
				new RedirectView("toIndex.do"));
	}	
}








