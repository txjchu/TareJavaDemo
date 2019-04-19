package netctoss.controller;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import netctoss.Exception.AdminCodeException;
import netctoss.Exception.PasswordException;
import netctoss.entity.Admin;
import netctoss.service.LoginService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController implements Serializable{
	
	@Resource		//依赖注入方式注入进一个LoginService实例
	private LoginService loginService;
	
	@ExceptionHandler
	public String execute(HttpServletRequest req, HttpServletResponse res, Exception e) throws Exception{
		if(e instanceof AdminCodeException || e instanceof PasswordException){
			//若是业务异常，则自己处理
			req.setAttribute("message", e.getMessage());//获取某个异常中的message
			req.setAttribute("adminCode", req.getParameter("adminCode"));//将当前请求对象中的参数赋值给新请求对象对应的属性中
			req.setAttribute("password", req.getParameter("password"));
			return "main/login";
		} else {
			//若是系统异常，则继续外抛给系统处理。
			System.out.println("捕获到一个系统异常："+ e.getClass().toString());
			throw e;
		}
	}
	
	@RequestMapping("/toLogin.do")		//用户打开浏览器输入http:ip:port/SpringNetctoss001/login/toLogin.do后进入的登录页面
	public String toLogin(){
		return "main/login";
	}
	
	@RequestMapping("/checkLogin.do")		//当用户填写完账号密码后，点击登录按钮，开始验证帐号密码
	public String checkLogin(String adminCode, String password, ModelMap model, HttpSession session){
		System.out.println("adminCode:"+ adminCode +",password:"+ password);
//		try {
//		Integer.valueOf("abc");//模拟程序出现系统异常，此处会抛出NumberFormatException异常，交给简单异常处理器处理了。
//		System.out.println("出异常了吗？");
		
			//spring异常处理：此处抛出的异常，将交给@ExceptionHandler注解的方法处理。
			Admin admin = loginService
					.checkAdminCodeAndPwd(adminCode, password);		//该方法会抛2个异常
			session.setAttribute("admin", admin);//将admin对象保存到session中，以备后续步骤的操作使用
			
//		} catch (AdminCodeException e) {//捕获验证账号异常后，需要将信息返回给页面，通知用户
//			model.addAttribute("message", e.getMessage());
//			model.addAttribute("adminCode", adminCode);
//			model.addAttribute("password", password);
//			return "main/login";	//账号异常后，跳转返回原登录页面
//		} catch (PasswordException e) {//捕获验证密码异常后，需要将信息返回给页面，通知用户
//			model.addAttribute("message", e.getMessage());
//			model.addAttribute("adminCode", adminCode);
//			model.addAttribute("password", password);
//			return "main/login";
//		}
		return "redirect:toIndex.do";//重定向去首页
//		return "main/error";//测试错误页面可用	
	}
	
	@RequestMapping("toIndex.do")			//当验证完帐号密码正确后，进入首页
	public String toIndex(){
		
		return "main/index";//跳转到首页页面
	}
}













