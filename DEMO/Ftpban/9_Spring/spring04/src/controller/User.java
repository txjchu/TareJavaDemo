package controller;
/**
 * 有哪些请求参数，该类必须提供和这些请求
 * 参数对应的属性(名称一致，类型要匹配)。
 * 这些属性要提供相应的get/set方法。
 *
 */
public class User {
	private String username;
	private String password;
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
