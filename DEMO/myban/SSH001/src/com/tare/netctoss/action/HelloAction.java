package com.tare.netctoss.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.tare.netctoss.dao.HelloDAO;

/**
 * 演示spring + Struts2
 * @author Administrator
 *
 */
@Controller
public class HelloAction {
	
	@Resource
	private HelloDAO helloDAO;
	
	private String msg;//用于向页面传递消息
	
	public String execute(){
		msg = helloDAO.say();
		return "success";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
