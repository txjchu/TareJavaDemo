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
 * ������ϰ��Controller������
 * 1.��ȡ��������е�����
 * 2.��ҳ�洫����
 * 3.�ض���
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/demo")
public class HelloController {
	
	//1.ͨ��request��ȡ����
	@RequestMapping("/test1.do")
	public ModelAndView test1(HttpServletRequest req){
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		System.out.println("test1��userName = "+ userName);
		System.out.println("test1��password = "+ password);
		return new ModelAndView("jsp/hello1");
	}
	//1.ͨ��@RequestParamע��
	@RequestMapping("/test2.do")
	public ModelAndView test2(String userName, @RequestParam("password") String pwd){
		System.out.println("test2�е�userName = "+ userName);
		System.out.println("test2�е�password = "+ pwd);
		
		return new ModelAndView("jsp/hello1");
	}
	//1.ͨ��Bean������ղ���
	@RequestMapping("/test3.do")
	public ModelAndView test3(User user){
		System.out.println("test3��user��name���� = "+ user.getUserName());
		System.out.println("test3��user��pwd���� = "+ user.getPassword());
		
		return new ModelAndView("jsp/hello1");
	}
	//2.ʹ��ModelAndView���ݳ�����
	@RequestMapping("/test4.do")
	public ModelAndView test4(){
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("success", true);
		data.put("message", "�����ɹ�!");
		return new ModelAndView("jsp/hello1", data);
	}
	//2.ʹ��ModelMap������������
	@RequestMapping("/test5.do")
	public ModelAndView test5(ModelMap model){
		model.addAttribute("success", false);
		model.addAttribute("message", "����ʧ�ܣ�");
		return new ModelAndView("jsp/hello1");
	}
	//2.ʹ��@ModelAttributeע����JSPҳ�洫ֵ
	//ʹ��@ModelAttribute����bean����
	@ModelAttribute("age")
	public int getAge(){
		return 25;
	}
	@RequestMapping("/test6.do")
	public ModelAndView test6( String userName,@ModelAttribute("password") String password){
		return new ModelAndView("jsp/hello1");	//�ɽ������еĲ�����ͨ����ע�ⷵ�ظ�ҳ�档�÷�����ĳ����û��ͨ����ע�ⷵ�����ݣ�ҳ�����ȡnull.
	}
	//2.ʹ��session��������
	@RequestMapping("/test7.do")
	public ModelAndView test7(HttpServletRequest req, User user){
		HttpSession session = req.getSession();
		session.setAttribute("salary", 6000);
		return new ModelAndView("jsp/hello1");
	}
	//?����String		--RequestMapping���Զ�����ȡ�����ַ���ת��Ϊҳ����
	@RequestMapping("/test8.do")
	public String test8( User user, ModelMap model){//User�����ᱻ�����Զ�ע�룬user�ĳ�ԱΪreq�л�ȡ���Ķ�Ӧ�Ĳ�����
		model.addAttribute("user", user);
		return "jsp/hello1";
	}
	//���ô���ҳ��
	@RequestMapping("/test9.do")
	public String test9(){
		return "jsp/error";
	}
	//3.ʹ��RedirectView����ʵ���ض���
	@RequestMapping("/test10.do")
	public ModelAndView test10(User user){
		System.out.println("test10��:"+ user.getUserName());
		if(user.getUserName().equals("tare")){
			return new ModelAndView("jsp/hello1");
		} else {
			return new ModelAndView(new RedirectView("test9.do"));//�ض������
		}
	}
	//3.ʹ��"redirect:"ǰ׺ʵ���ض���
	@RequestMapping("/test11.do")
	public String test11(User user){
		if(user.getUserName().equals("tare")){
			return "jsp/hello1";
		} else {
			return "redirect:test9.do";
		}
	}
}


















