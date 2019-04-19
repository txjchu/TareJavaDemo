package netctoss.controller;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import netctoss.entity.Admin;
import netctoss.exception.AdminCodeException;
import netctoss.exception.PasswordException;
import netctoss.service.LoginService;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 登录模块的Controller 二级（相对于前端控制器DispatcherServlet）控制器，
 * 根据请求路径分发调用具体业务逻辑处理组件，并分别返回ModelAndView。
 * @author Administrator
 *
 */
@Controller					//控制层组件注解
@RequestMapping("/login")	//请求映射注解，表面该类或方法与哪个请求路径对应
public class LoginController implements Serializable {
	
	//创建业务层组件对象	成员属性	用来调用其方法处理逻辑业务
	@Resource
	private LoginService loginService;
	
	//去登录页面
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "main/login";
	}
	//登录页面点击登录按钮后进入的页面
	@RequestMapping("/checkLogin.do")
	public String checkLogin(String adminCode, String password, ModelMap model, HttpSession session){
		System.out.println("adminCode:"+ adminCode +",password:"+ password);
		try {
			Admin admin = loginService.checkAdminCodeAndPwd(adminCode, password);
			session.setAttribute("admin", admin);//将获取到的admin放入session属性中，便于后续操作读取该admin的信息
		} catch (AdminCodeException e) {
			/*
			 * 若是应用异常，则明确告知用户
			 */
			model.addAttribute("message", e.getMessage());
			model.addAttribute("adminCode", adminCode);
			model.addAttribute("password", password);
			return "main/login";
		} catch (PasswordException e) {
			model.addAttribute("message", e.getMessage());
			model.addAttribute("adminCode", adminCode);
			model.addAttribute("password", password);
			return "main/login";
		} 
		return "redirect:toIndex.do";//若业务层组件方法没有抛异常，则说明验证成功，重定向到首页		
	}
	
	//登录成功后去首页
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "main/index";
	}
}








