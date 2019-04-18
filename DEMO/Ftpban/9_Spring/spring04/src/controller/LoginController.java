package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/login1.do")
	public String checkLogin1(
			HttpServletRequest request){
		String username = 
			request.getParameter("username");
		String pwd = 
			request.getParameter("password");
		System.out.println("username:" 
				+ username + " password:" + pwd);
		return "success";
	}
	
	@RequestMapping("/login2.do")
	public String checkLogin2(String username,
			@RequestParam("password") String pwd){
		System.out.println("checkLogin2方法 ...");
		System.out.println("username:" 
				+ username + " password:" 
				+ pwd);
		return "success";
	}
	
	@RequestMapping("/login3.do")
	public String checkLogin3(User user){
		System.out.println("checkLogin3方法...");
		System.out.println("username:"
				+ user.getUsername() 
				+ " password:" + user.getPassword());
		return "success";
	}
	
	@RequestMapping("/login4.do")
	//向jsp传值 (使用request)
	public String checkLogin4(HttpServletRequest 
			request){
		System.out.println("checkLogin4方法...");
		request.setAttribute("message", "welcome");
		return "success";
	}
	
	@RequestMapping("/login5.do")
	//向jsp传值(使用session)
	public String checkLogin5(HttpSession session){
		System.out.println("checkLogin5方法...");
		session.setAttribute("message", "welcome!!!");
		return "success";
	}
	
	@RequestMapping("/login6.do")
	//使用ModelAndView向jsp传值
	public ModelAndView checkLogin6(){
		System.out.println("checkLogin6方法...");
		Map<String,String> data = 
			new HashMap<String,String>();
		data.put("message", "welcome hahaha");
		return new ModelAndView("success",data);
	}
	
	@RequestMapping("/login7.do")
	//使用ModelMap向jsp传值
	public String checkLogin7(ModelMap data){
		System.out.println("checkLogin7方法...");
		data.put("message", "welcome hehe");
		return "success";
	}
	
	@RequestMapping("/login8.do")
	//使用@ModelAttribute向jsp传值
	public String checkLogin8(
			@ModelAttribute("username") String username){
		System.out.println("checkLogin8方法...");
		return "success";
	}
	
	
}
















