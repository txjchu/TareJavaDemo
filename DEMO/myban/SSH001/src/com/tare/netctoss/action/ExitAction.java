package com.tare.netctoss.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tare.netctoss.entity.Admin;

/**
 * 退出业务的Action
 * 继承基础Action后，获取session中储存的admin，实现退出的做法就是删除session中的admin对应的对象。
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class ExitAction extends BaseAction{

	//input
	
	
	public String exit(){
		Object admin = session.get("admin");
		System.out.println("-->进入了退出Action：获取到的admin:"+ admin);
		if(admin != null){
			session.put("admin", null);
		}
		return "login";
	}
}
