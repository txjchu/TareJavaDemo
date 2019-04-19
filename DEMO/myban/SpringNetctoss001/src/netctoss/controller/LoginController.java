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
 * ��¼������
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController implements Serializable{
	
	@Resource		//����ע�뷽ʽע���һ��LoginServiceʵ��
	private LoginService loginService;
	
	@ExceptionHandler
	public String execute(HttpServletRequest req, HttpServletResponse res, Exception e) throws Exception{
		if(e instanceof AdminCodeException || e instanceof PasswordException){
			//����ҵ���쳣�����Լ�����
			req.setAttribute("message", e.getMessage());//��ȡĳ���쳣�е�message
			req.setAttribute("adminCode", req.getParameter("adminCode"));//����ǰ��������еĲ�����ֵ������������Ӧ��������
			req.setAttribute("password", req.getParameter("password"));
			return "main/login";
		} else {
			//����ϵͳ�쳣����������׸�ϵͳ����
			System.out.println("����һ��ϵͳ�쳣��"+ e.getClass().toString());
			throw e;
		}
	}
	
	@RequestMapping("/toLogin.do")		//�û������������http:ip:port/SpringNetctoss001/login/toLogin.do�����ĵ�¼ҳ��
	public String toLogin(){
		return "main/login";
	}
	
	@RequestMapping("/checkLogin.do")		//���û���д���˺�����󣬵����¼��ť����ʼ��֤�ʺ�����
	public String checkLogin(String adminCode, String password, ModelMap model, HttpSession session){
		System.out.println("adminCode:"+ adminCode +",password:"+ password);
//		try {
//		Integer.valueOf("abc");//ģ��������ϵͳ�쳣���˴����׳�NumberFormatException�쳣���������쳣�����������ˡ�
//		System.out.println("���쳣����");
		
			//spring�쳣�����˴��׳����쳣��������@ExceptionHandlerע��ķ�������
			Admin admin = loginService
					.checkAdminCodeAndPwd(adminCode, password);		//�÷�������2���쳣
			session.setAttribute("admin", admin);//��admin���󱣴浽session�У��Ա���������Ĳ���ʹ��
			
//		} catch (AdminCodeException e) {//������֤�˺��쳣����Ҫ����Ϣ���ظ�ҳ�棬֪ͨ�û�
//			model.addAttribute("message", e.getMessage());
//			model.addAttribute("adminCode", adminCode);
//			model.addAttribute("password", password);
//			return "main/login";	//�˺��쳣����ת����ԭ��¼ҳ��
//		} catch (PasswordException e) {//������֤�����쳣����Ҫ����Ϣ���ظ�ҳ�棬֪ͨ�û�
//			model.addAttribute("message", e.getMessage());
//			model.addAttribute("adminCode", adminCode);
//			model.addAttribute("password", password);
//			return "main/login";
//		}
		return "redirect:toIndex.do";//�ض���ȥ��ҳ
//		return "main/error";//���Դ���ҳ�����	
	}
	
	@RequestMapping("toIndex.do")			//����֤���ʺ�������ȷ�󣬽�����ҳ
	public String toIndex(){
		
		return "main/index";//��ת����ҳҳ��
	}
}













