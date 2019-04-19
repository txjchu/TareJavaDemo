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
@RequestMapping("/login")//----��¼ģ�� 
public class LoginController {
	@RequestMapping("/toLogin.do")
	public String toLogin(){		
		return "login";
	}
	
	@RequestMapping("/login1.do")
	public String checkLogin1(HttpServletRequest req){
		String username = req.getParameter("username");
		String pwd = req.getParameter("password");
		System.out.println("�û�����"+username+"����:"+pwd);
		return "success";//----��ͼ��
	}
	@RequestMapping("/login2.do")
	public String checkLogin2(String username,@RequestParam("password") String pwd){//----������󴫹����Ĳ�������һ������Ҫ�ڲ���֮ǰ@RequestParam�������ֵ�����֡�
		System.out.println("checkLogin2����...");
		System.out.println("username:"+username+"password:"+pwd);
		return "success";
	}
	@RequestMapping("/login3.do")
	public String checkLogin3(User user){
		System.out.println("checkLogin3����....");
		System.out.println("3�û�����"+user.getUsername()+"���룺"+user.getPassword());
		return "success";
	}
	
	@RequestMapping("/login4.do")
	//��jsp��ֵ(ʹ��request����)
	public String checkLogin4(HttpServletRequest req){
		System.out.println("checkLogin4����...");
		req.setAttribute("message","welcome");
		return "success";
	}
	@RequestMapping("/login5.do")
	//��jsp��ֵ(ʹ��session)
	public String checkLogin5(HttpSession session){
		System.out.println("checkLogin5����...");
		session.setAttribute("message","welcome5");
		return "success";
	}	
	@RequestMapping("/login6.do")
	//ʹ��ModelAndView(Map)��jsp��ֵ
	public ModelAndView checkLogin6(){
		System.out.println("checkLogin6����...");
		Map<String,String> data = new HashMap<String,String>();
		data.put("message","welcome6 hahaha");	
		return new ModelAndView("success",data);
	}
	
	@RequestMapping("/login7.do")
	//ʹ��ModelMap��jsp��ֵ
	public String checkLogin7(ModelMap data){
		/**
		 * ���Դ���Ĳ�������Щ���ͣ�
		 */
		System.out.println("checkLogin7����...");
		data.put("message","welcome7 hehe");
		return "success";
	}
	@RequestMapping("/login8.do")
	//ʹ��@ModelAttribute��jsp��ֵ
	public String checkLogin8(@ModelAttribute("username")String username){
		System.out.println("checkLogin8����...");
		return "success";
	}
	
	@RequestMapping("/login9.do")
	public String checkLogin9(String username){
		if("tom".equals(username)){
			//redirect:�ض���success.jsp
			return "redirect:toSuccess.do";
		}
		return "login";		//----ת��
	}
	@RequestMapping("/toSuccess.do")
	public String toSuccess(){
		return "success";	//----����һ����ͼ��
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
