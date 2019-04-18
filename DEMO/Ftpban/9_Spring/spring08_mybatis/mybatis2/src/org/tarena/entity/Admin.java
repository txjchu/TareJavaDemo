package org.tarena.entity;

import java.io.Serializable;
import java.sql.Date;

public class Admin implements Serializable{
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
	
}
