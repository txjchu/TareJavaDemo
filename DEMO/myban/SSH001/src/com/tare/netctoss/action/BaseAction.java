package com.tare.netctoss.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

/**
 * ����Action��ʵ��SessionAware�ӿڣ���Struts2�л�ȡsession�ķ�ʽ��
 * ʵ��setSession(Map session)����������ʹ��session��������ҳ�����ݡ�
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
