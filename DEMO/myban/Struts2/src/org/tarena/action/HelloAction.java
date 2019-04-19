package org.tarena.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {
	
	/**
	 * public String不能改变，业务方法，默认名为execute
	 * @return result标识名
	 */
	public String execute(){
		
		return "success";//为了后面根据名字，找result的定义
	}	
}
