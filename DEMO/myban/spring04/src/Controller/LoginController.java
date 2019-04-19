package Controller;

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

@Controller
@RequestMapping("/login")//----登录模块 
public class LoginController {
	@RequestMapping("/toLogin.do")
	public String toLogin(){		
		return "login";
	}
	
	@RequestMapping("/login1.do")
	public String checkLogin1(HttpServletRequest req){
		String username = req.getParameter("username");
		String pwd = req.getParameter("password");
		System.out.println("用户名："+username+"密码:"+pwd);
		return "success";//----视图名
	}
	@RequestMapping("/login2.do")
	public String checkLogin2(String username,@RequestParam("password") String pwd){//----如果请求传过来的参数名不一样，需要在参数之前@RequestParam定义参数值的名字。
		System.out.println("checkLogin2方法...");
		System.out.println("username:"+username+"password:"+pwd);
		return "success";
	}
	@RequestMapping("/login3.do")
	public String checkLogin3(User user){
		System.out.println("checkLogin3方法....");
		System.out.println("3用户名："+user.getUsername()+"密码："+user.getPassword());
		return "success";
	}
	
	@RequestMapping("/login4.do")
	//向jsp传值(使用request对象)
	public String checkLogin4(HttpServletRequest req){
		System.out.println("checkLogin4方法...");
		req.setAttribute("message","welcome");
		return "success";
	}
	@RequestMapping("/login5.do")
	//向jsp传值(使用session)
	public String checkLogin5(HttpSession session){
		System.out.println("checkLogin5方法...");
		session.setAttribute("message","welcome5");
		return "success";
	}	
	@RequestMapping("/login6.do")
	//使用ModelAndView(Map)向jsp传值
	public ModelAndView checkLogin6(){
		System.out.println("checkLogin6方法...");
		Map<String,String> data = new HashMap<String,String>();
		data.put("message","welcome6 hahaha");	
		return new ModelAndView("success",data);
	}
	
	@RequestMapping("/login7.do")
	//使用ModelMap向jsp传值
	public String checkLogin7(ModelMap data){
		/**
		 * 可以传入的参数有哪些类型？
		 */
		System.out.println("checkLogin7方法...");
		data.put("message","welcome7 hehe");
		return "success";
	}
	@RequestMapping("/login8.do")
	//使用@ModelAttribute向jsp传值
	public String checkLogin8(@ModelAttribute("username")String username){
		System.out.println("checkLogin8方法...");
		return "success";
	}
	
	@RequestMapping("/login9.do")
	public String checkLogin9(String username){
		if("tom".equals(username)){
			//redirect:重定向到success.jsp
			return "redirect:toSuccess.do";
		}
		return "login";		//----转发
	}
	@RequestMapping("/toSuccess.do")
	public String toSuccess(){
		return "success";	//----返回一个视图名
	}
	@RequestMapping("/login10.do")
	public ModelAndView checkLogin10(String username){
		if("tom".equals(username)){
			RedirectView rv = new RedirectView("toSuccess.do");
			return new ModelAndView(rv);
		}
		return new ModelAndView("login");
	}
}
