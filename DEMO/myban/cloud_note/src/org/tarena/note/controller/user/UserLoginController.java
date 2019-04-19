package org.tarena.note.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.note.service.UserService;
import org.tarena.note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody			//该注解用于处理响应ajax请求时，将数据转换为json格式字符串输出给浏览器jsp页面。
	public NoteResult execute(String username,String password){	//返回NoteResult,后续用MVC转为JSON类型响应输出
		//调用业务组件处理
		NoteResult result = userService.checkLogin(username, password);
		return result;
	}
}
