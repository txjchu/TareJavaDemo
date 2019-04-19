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
 * ��¼ģ���Controller �����������ǰ�˿�����DispatcherServlet����������
 * ��������·���ַ����þ���ҵ���߼�������������ֱ𷵻�ModelAndView��
 * @author Administrator
 *
 */
@Controller					//���Ʋ����ע��
@RequestMapping("/login")	//����ӳ��ע�⣬�������򷽷����ĸ�����·����Ӧ
public class LoginController implements Serializable {
	
	//����ҵ����������	��Ա����	���������䷽�������߼�ҵ��
	@Resource
	private LoginService loginService;
	
	//ȥ��¼ҳ��
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "main/login";
	}
	//��¼ҳ������¼��ť������ҳ��
	@RequestMapping("/checkLogin.do")
	public String checkLogin(String adminCode, String password, ModelMap model, HttpSession session){
		System.out.println("adminCode:"+ adminCode +",password:"+ password);
		try {
			Admin admin = loginService.checkAdminCodeAndPwd(adminCode, password);
			session.setAttribute("admin", admin);//����ȡ����admin����session�����У����ں���������ȡ��admin����Ϣ
		} catch (AdminCodeException e) {
			/*
			 * ����Ӧ���쳣������ȷ��֪�û�
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
		return "redirect:toIndex.do";//��ҵ����������û�����쳣����˵����֤�ɹ����ض�����ҳ		
	}
	
	//��¼�ɹ���ȥ��ҳ
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "main/index";
	}
}








