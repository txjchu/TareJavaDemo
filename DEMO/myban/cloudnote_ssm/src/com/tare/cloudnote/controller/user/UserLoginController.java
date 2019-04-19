package com.tare.cloudnote.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tare.cloudnote.service.UserService;
import com.tare.cloudnote.util.NoteResult;

/**
 * �����û���¼����Ŀ��Ʋ㡣
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserLoginController {
	
	@Resource
	private UserService service;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public NoteResult execute(String username, String password){
		NoteResult result = service.checkLogin(username, password);
		return result;
	}
}
