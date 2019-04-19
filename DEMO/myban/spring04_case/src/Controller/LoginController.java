package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/login.do")
	public String toLogin(){
		System.out.println("toLogin方法正在执行...");
		return "login";
	}
}
