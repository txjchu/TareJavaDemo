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
		System.out.println("checkLogin2���� ...");
		System.out.println("username:" 
				+ username + " password:" 
				+ pwd);
		return "success";
	}
	
	@RequestMapping("/login3.do")
	public String checkLogin3(User user){
		System.out.println("checkLogin3����...");
		System.out.println("username:"
				+ user.getUsername() 
				+ " password:" + user.getPassword());
		return "success";
	}
	
	@RequestMapping("/login4.do")
	//��jsp��ֵ (ʹ��request)
	public String checkLogin4(HttpServletRequest 
			request){
		System.out.println("checkLogin4����...");
		request.setAttribute("message", "welcome");
		return "success";
	}
	
	@RequestMapping("/login5.do")
	//��jsp��ֵ(ʹ��session)
	public String checkLogin5(HttpSession session){
		System.out.println("checkLogin5����...");
		session.setAttribute("message", "welcome!!!");
		return "success";
	}
	
	@RequestMapping("/login6.do")
	//ʹ��ModelAndView��jsp��ֵ
	public ModelAndView checkLogin6(){
		System.out.println("checkLogin6����...");
		Map<String,String> data = 
			new HashMap<String,String>();
		data.put("message", "welcome hahaha");
		return new ModelAndView("success",data);
	}
	
	@RequestMapping("/login7.do")
	//ʹ��ModelMap��jsp��ֵ
	public String checkLogin7(ModelMap data){
		System.out.println("checkLogin7����...");
		data.put("message", "welcome hehe");
		return "success";
	}
	
	@RequestMapping("/login8.do")
	//ʹ��@ModelAttribute��jsp��ֵ
	public String checkLogin8(
			@ModelAttribute("username") String username){
		System.out.println("checkLogin8����...");
		return "success";
	}
	
	
}
















