package com.tare.web;

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
import org.springframework.web.servlet.view.RedirectView;

import com.tare.entity.User;

/**
 * 案例练习：Controller控制器
 * 1.获取请求对象中的数据
 * 2.向页面传数据
 * 3.重定向
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/demo")
public class HelloController {
	
	//1.通过request获取数据
	@RequestMapping("/test1.do")
	public ModelAndView test1(HttpServletRequest req){
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		System.out.println("test1中userName = "+ userName);
		System.out.println("test1中password = "+ password);
		return new ModelAndView("jsp/hello1");
	}
	//1.通过@RequestParam注解
	@RequestMapping("/test2.do")
	public ModelAndView test2(String userName, @RequestParam("password") String pwd){
		System.out.println("test2中的userName = "+ userName);
		System.out.println("test2中的password = "+ pwd);
		
		return new ModelAndView("jsp/hello1");
	}
	//1.通过Bean对象接收参数
	@RequestMapping("/test3.do")
	public ModelAndView test3(User user){
		System.out.println("test3中user的name属性 = "+ user.getUserName());
		System.out.println("test3中user的pwd属性 = "+ user.getPassword());
		
		return new ModelAndView("jsp/hello1");
	}
	//2.使用ModelAndView传递出参数
	@RequestMapping("/test4.do")
	public ModelAndView test4(){
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("success", true);
		data.put("message", "操作成功!");
		return new ModelAndView("jsp/hello1", data);
	}
	//2.使用ModelMap参数传出数据
	@RequestMapping("/test5.do")
	public ModelAndView test5(ModelMap model){
		model.addAttribute("success", false);
		model.addAttribute("message", "操作失败！");
		return new ModelAndView("jsp/hello1");
	}
	//2.使用@ModelAttribute注解向JSP页面传值
	//使用@ModelAttribute传出bean属性
	@ModelAttribute("age")
	public int getAge(){
		return 25;
	}
	@RequestMapping("/test6.do")
	public ModelAndView test6( String userName,@ModelAttribute("password") String password){
		return new ModelAndView("jsp/hello1");	//可将请求中的参数，通过该注解返回给页面。该方法若某参数没有通过该注解返回数据，页面则获取null.
	}
	//2.使用session传出数据
	@RequestMapping("/test7.do")
	public ModelAndView test7(HttpServletRequest req, User user){
		HttpSession session = req.getSession();
		session.setAttribute("salary", 6000);
		return new ModelAndView("jsp/hello1");
	}
	//?返回String		--RequestMapping会自动将获取到的字符串转换为页面名
	@RequestMapping("/test8.do")
	public String test8( User user, ModelMap model){//User参数会被容器自动注入，user的成员为req中获取到的对应的参数。
		model.addAttribute("user", user);
		return "jsp/hello1";
	}
	//配置错误页面
	@RequestMapping("/test9.do")
	public String test9(){
		return "jsp/error";
	}
	//3.使用RedirectView对象实现重定向
	@RequestMapping("/test10.do")
	public ModelAndView test10(User user){
		System.out.println("test10中:"+ user.getUserName());
		if(user.getUserName().equals("tare")){
			return new ModelAndView("jsp/hello1");
		} else {
			return new ModelAndView(new RedirectView("test9.do"));//重定向对象
		}
	}
	//3.使用"redirect:"前缀实现重定向
	@RequestMapping("/test11.do")
	public String test11(User user){
		if(user.getUserName().equals("tare")){
			return "jsp/hello1";
		} else {
			return "redirect:test9.do";
		}
	}
}


















