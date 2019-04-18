package org.tarena.action;

public class LoginAction {

	//接收请求参数
	private String username;//根页面<input type="text" name="username">对应
	private String password;

	public String execute(){
		//获取请求参数,调用Service,Dao处理
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
