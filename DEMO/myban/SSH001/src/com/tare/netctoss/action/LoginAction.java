package com.tare.netctoss.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.tare.netctoss.dao.ILoginDAO;
import com.tare.netctoss.entity.Admin;

/**
 * ����ȥ��¼ҳ��������߼���Action
 * �̳л���Action������ʹ��session��ȡ���ݡ�
 * ȡ��ȡ����֤��ͼƬAction�����д�ŵ���֤��
 * �棺��¼��ɺ󣬽��û���Ϣ����session���Ա�����ҳ������ĵ�¼��֤����֤�û��Ƿ��¼�� 
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class LoginAction extends BaseAction{

	@Resource
	private ILoginDAO loginDao;
	
	//input
	private String adminCode;
	private String password;
	private String verifyCode;//�����û��������֤��
	//output
	private String errormsg;//��ҳ�������֤�����ʾ��Ϣ
	
	public String login(){
		//��֤��֤���Ƿ�������ȷ
		String imageCode = (String) session.get("imageCode");//��ȡsession�д洢����֤�롣
		System.out.println("-->loginAction:imageCode="+ imageCode);
		if(!imageCode.equalsIgnoreCase(verifyCode)){	//equalsIgnoreCase ���Դ�Сд
			errormsg = "��֤�������������������룡";
			return "fail";
		}
		
		//��֤�˺ź������Ƿ�Ϊ��
		if("".equals(adminCode)){
			errormsg = "�û���Ϊ�գ��������û�����";
			return "fail";
		} else if("".equals(password)){
			errormsg = "����Ϊ�գ����������룡";
			return "fail";
		}
		//��֤�˺ź������Ƿ�������ȷ
		Admin admin = null; 
		try {
			admin = loginDao.findByCode(adminCode);
		} catch (Exception e) {
			e.printStackTrace();
			errormsg = "��ѯ���ݿ��쳣�ˣ�";
			return "error";
		}
		if(admin == null || !password.equals(admin.getPassword())){
			errormsg = "�˺Ų����ڻ����벻��ȷ�����������룡";
		} else if(adminCode.equals(admin.getAdmin_code()) && password.equals(admin.getPassword())){
			session.put("admin", admin);//��¼�ɹ������û���Ϣ����session�У��Ա������ĵ�¼��֤��
			return "success";
		}
		return "fail";
	}
	
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
}
