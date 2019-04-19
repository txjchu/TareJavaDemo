package netctoss.entity;

import java.sql.Timestamp;

/**
 * 管理员Admin实体类
 * 每个成员属性分别对应数据库中 admin 表的字段。
 * @author Administrator
 *
 */
public class Admin {
	private Integer adminId;	//账号id	admin_id
	private String adminCode;  	//账号	admin_code
	private String pwd;			//密码	表中字段名为password
	private String name;		//用户姓名
	private String telephone;	//用户电话
	private String email;		//用户邮箱
	private Timestamp enrollDate;	//timestamp 时间戳		enroll 登记注册
	
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminCode=" + adminCode
				+ ", pwd=" + pwd + ", name=" + name + ", telephone="
				+ telephone + ", email=" + email + ", enrollDate=" + enrollDate
				+ "]";
	}
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public Timestamp getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Timestamp enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	
}
