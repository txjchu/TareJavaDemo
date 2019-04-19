package org.tarena.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class ScopeAction implements RequestAware,SessionAware,ApplicationAware{
	//�����֣�ע�뷽ʽ
	/**
	 * Action�����ʱ��ʵ��(������Action���)
	 * Map�ṹ��RequestAware,SessionAware,ApplicationAware�ӿڵķ���
	 * Servlet���ͣ�ServletRequestAware,ServletResponseAware,ServletContextAware.
	 */
	
	private Map<String,Object> request;
	private Map<String,Object> session;
	private Map<String,Object> application;
	
	public String execute(){
		//��request,session,application��ֵ
		request.put("msg","request��Ϣ");
		session.put("msg","session��Ϣ");
		application.put("msg","application��Ϣ");
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
