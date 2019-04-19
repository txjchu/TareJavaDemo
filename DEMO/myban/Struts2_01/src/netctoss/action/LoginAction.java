package netctoss.action;

import netctoss.dao.DAOFactory;
import netctoss.dao.LoginDAO;
import netctoss.entity.Admin;

/**
 * ��¼ + ��֤ģ���Action
 * @author Administrator
 *
 */
public class LoginAction extends BaseAction{//�̳�Action���࣬��ȡsession
	//input
	private String adminCode;
	private String password;
	//output
	private String errormsg;//�����ҳ�����Ϣ����ʾ��¼��֤���
	//�����û��������֤��
	private String verifyCode;
	
	public String checkLogin(){
		//����֤�û��������֤���Ƿ���ȷ
		String imageCode = (String) session.get("imageCode");
		System.out.println("LoginAction�л�ȡ������֤�룺"+ imageCode);
		System.out.println("�û��������֤���ǣ�"+ verifyCode);
		if(verifyCode == null || !imageCode.equalsIgnoreCase(verifyCode)){//ʹ��ȷ���ַ�����equals��������ֹ��ָ���쳣��
			//��֤��û�����룬���������ɵ���֤�벻ƥ��
			errormsg = "��֤����������";
			return "fail";
		}
		if("".equals(adminCode)){
			errormsg = "�û���Ϊ�գ��������˺ź����룡";
			return "fail";
		}
		LoginDAO loginDAO = DAOFactory.getLoginDAO();
		Admin admin = null;
		try {
			admin = loginDAO.findByCode(adminCode);
			System.out.println("LoginAction�е���DAO�ķ�����ȡ����admin:"+ admin);
		} catch (Exception e) {//��ͨ���˺Ż�ȡ�û����쳣
			e.printStackTrace();
			System.out.println("DAO��ȡ�û���Ϣ���쳣..");
			return "error";//��ת���쳣����
		}
		if(admin != null && adminCode.equals(admin.getAdminCode())){	// ���˺Ų����ڿ��ַ����������˷�!
			if(!password.equals("") && password.equals(admin.getPassword())){
				session.put("admin", admin);
				return "success";
			} else {
				errormsg = "���벻��ȷ����";
				return "fail";
			}
		} else {
			errormsg = "�û��������ڣ���";
			return "fail";	// failʧ��
		}
		
	}
	
	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
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
	
}
