package org.tarena.action;

public class LoginAction {

	//�����������
	private String username;//��ҳ��<input type="text" name="username">��Ӧ
	private String password;

	public String execute(){
		//��ȡ�������,����Service,Dao����
		System.out.println(username+":"+password);
		if("scott".equals(username) 
			&& "123456".equals(password) ){
			return "success";
		}
		return "error";
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
