package com.tare.netctoss.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tare.netctoss.entity.Admin;

/**
 * �˳�ҵ���Action
 * �̳л���Action�󣬻�ȡsession�д����admin��ʵ���˳�����������ɾ��session�е�admin��Ӧ�Ķ���
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class ExitAction extends BaseAction{

	//input
	
	
	public String exit(){
		Object admin = session.get("admin");
		System.out.println("-->�������˳�Action����ȡ����admin:"+ admin);
		if(admin != null){
			session.put("admin", null);
		}
		return "login";
	}
}
