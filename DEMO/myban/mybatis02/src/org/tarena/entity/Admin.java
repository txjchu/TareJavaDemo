package org.tarena.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 实体类
 * 1.实现序列化Serializable(为了a.网络中对象传递，b.磁盘文件读写。)
 * 2.属性类型采用封装类型，尤其是框架。(封装类包含null,可以降低出错几率。)
 * 3.属性名称与字段名一致。(仅限于MyBatis)
 * 
 */
public class Admin implements Serializable {
	private Integer admin_id;
	private String admin_code;
	private String password;
	private String name;
	private String telephone;
	private String email;
	private Date enrolldate;
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer adminId) {
		admin_id = adminId;
	}
	public String getAdmin_code() {
		return admin_code;
	}
	public void setAdmin_code(String adminCode) {
		admin_code = adminCode;
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
	public Date getEnrolldate() {
		return enrolldate;
	}
	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_code=" + admin_code
				+ ", password=" + password + ", name=" + name + ", email="
				+ email + ", telephone=" + telephone + ", enrolldate="
				+ enrolldate + "]";
	}
	
}
