package netctoss.entity;

import java.sql.Timestamp;

/**
 * 管理员实体类
 * @author Administrator
 *
 */
public class Admin {
	private Integer adminId;			//用户id
	private String adminCode;			//用户账号
	private String password;			//密码
	private String name;				//用户姓名
	private String telephone;
	private String email;
	private Timestamp enrolldate;		//注册时间		时间戳
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getEnrolldate() {
		return enrolldate;
	}
	public void setEnrolldate(Timestamp enrolldate) {
		this.enrolldate = enrolldate;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminCode=" + adminCode
				+ ", password=" + password + ", name=" + name + ", telephone="
				+ telephone + ", email=" + email + ", enrolldate=" + enrolldate
				+ "]";
	}
	
	
}
