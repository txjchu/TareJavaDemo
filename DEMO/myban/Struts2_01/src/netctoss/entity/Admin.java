package netctoss.entity;

import java.sql.Date;

/**
 * Admin数据表对应的实体类：
 * 封装管理员属性
 * @author Administrator
 *
 */
public class Admin {
	
	private Integer id;// 主键
    private String adminCode;// 账号
    private String password;// 密码
    private String name;// 姓名
    private String telephone;// 电话
    private String email;// 邮件
    private Date enrollDate;// 创建日期
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminCode=" + adminCode + ", password="
				+ password + ", name=" + name + ", telephone=" + telephone
				+ ", email=" + email + ", enrollDate=" + enrollDate + "]";
	}
    
    
}
