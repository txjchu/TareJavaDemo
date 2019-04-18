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
	
	@RequestMapping("/login.do")
	public ModelAndView checkLogin(
			String adminCode,String pwd,
			HttpSession session){
		System.out.println(
				"adminCode:" 
				+ adminCode + " pwd:" + pwd);
		try {
			Admin admin = 
				loginService.login(adminCode, pwd);
			session.setAttribute("admin", admin);
		} catch (Exception e) {
			e.printStackTrace();
			if(e instanceof ApplicationException){
				//Ӧ���쳣��Ҫ��ȷ��ʾ�û�
				Map<String,String> data = 
					new HashMap<String,String>();
				data.put("adminCode", adminCode);
				data.put("message", e.getMessage());
				return new ModelAndView("login",data);
			}
			//ϵͳ�쳣,��ʾ�û��Ժ�����
			return new ModelAndView("error");
		}
		//��¼�ɹ�,�ض�����ҳ
		return new ModelAndView(
				new RedirectView("toIndex.do"));
	}
}
