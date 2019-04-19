package com.tare.netctoss.entity;

import java.sql.Date;

/**
 * 数据表Admin_info对应的实体类
 * @author Administrator
 *
 */
public class Admin {
	
	private Integer admin_id;// 主键
    private String admin_code;// 账号
    private String password;// 密码
    private String name;// 姓名
    private String telephone;// 电话
    private String email;// 邮件
    private Date enrollDate;// 创建日期
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_code() {
		return admin_code;
	}
	public void setAdmin_code(String admin_code) {
		this.admin_code = admin_code;
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
		return "Admin [admin_id=" + admin_id + ", admin_ode=" + admin_code
				+ ", password=" + password + ", name=" + name + ", telephone="
				+ telephone + ", email=" + email + ", enrollDate=" + enrollDate
				+ "]";
	}
    
}
