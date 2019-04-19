package com.tare.cloudnote.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tare.cloudnote.entity.User;
import com.tare.cloudnote.service.UserService;
import com.tare.cloudnote.util.NoteResult;

/**
 * 处理注册请求Controller组件
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserRegistController {

	@Resource
	private UserService userService;
	
	@ResponseBody					//返回json数据。
	@RequestMapping("/regist.do") 
	public NoteResult execute(String username, String password, String nickname){
		NoteResult result = userService.registUser(username, password, nickname);
		
		return result;
	}
}
