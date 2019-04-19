package com.tare.netctoss.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

/**
 * 基础Action，实现SessionAware接口，是Struts2中获取session的方式。
 * 实现setSession(Map session)方法，可以使用session传输设置页面数据。
 * @author Administrator
 *
 */
public class BaseAction implements SessionAware{

	protected Map<String, Object> session;
	
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;		
	}

	public Map<String, Object> getSession() {
		return session;
	}
	
	
	
}
