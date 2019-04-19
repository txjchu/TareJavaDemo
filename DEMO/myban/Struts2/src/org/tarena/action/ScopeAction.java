package org.tarena.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class ScopeAction implements RequestAware,SessionAware,ApplicationAware{
	//第三种：注入方式
	/**
	 * Action对象的时候实现(仅限于Action组件)
	 * Map结构：RequestAware,SessionAware,ApplicationAware接口的方法
	 * Servlet类型：ServletRequestAware,ServletResponseAware,ServletContextAware.
	 */
	
	private Map<String,Object> request;
	private Map<String,Object> session;
	private Map<String,Object> application;
	
	public String execute(){
		//向request,session,application存值
		request.put("msg","request信息");
		session.put("msg","session信息");
		application.put("msg","application信息");
		return "success";//scope.jsp
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setApplication(Map<String, Object> aplication) {
		// TODO Auto-generated method stub
		
	}
}
