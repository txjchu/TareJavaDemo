package org.tarena.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {
	
	/**
	 * public String���ܸı䣬ҵ�񷽷���Ĭ����Ϊexecute
	 * @return result��ʶ��
	 */
	public String execute(){
		
		return "success";//Ϊ�˺���������֣���result�Ķ���
	}	
}
