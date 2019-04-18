package org.tarena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.entity.User;

@Controller
public class Ajax1Controller {

	@RequestMapping("/ajax1.do")
	@ResponseBody//将user转成json字符串输出
	public User execute(){
		User user = new User();
		user.setId(1);
		user.setName("scott");
		return user;
	}
	
}
