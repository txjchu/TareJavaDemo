package netctoss.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

/**
 * Action�Ļ��࣬ͬһʹ��ע�뷽ʽ��ȡsession����������֤��¼
 * @author Administrator
 *
 */
public class BaseAction implements SessionAware{

	protected Map<String, Object> session;	//�������δ�����Ϊprotected����̳����������Լ̳и����ԡ�
	/*
	 * ���ýӿ�ע��ķ�ʽ��ȡsession
	 * 
	 */
	public void setSession(Map<String, Object> arg) {
		session = arg;				
	}
	
}
