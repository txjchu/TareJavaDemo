package netctoss.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

/**
 * Action的基类，同一使用注入方式获取session对象，用来验证登录
 * @author Administrator
 *
 */
public class BaseAction implements SessionAware{

	protected Map<String, Object> session;	//将其修饰词设置为protected，则继承其的子类可以继承该属性。
	/*
	 * 采用接口注入的方式获取session
	 * 
	 */
	public void setSession(Map<String, Object> arg) {
		session = arg;				
	}
	
}
