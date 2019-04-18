package netctoss.entity;

import java.sql.Timestamp;


public class Admin {
	private Integer adminId;
	private String adminCode;
	private String pwd;
	private String name;
	private String telephone;
	private String email;
	private Timestamp enrollDate;
	
	@Override
	public String toString() {
		return adminId + " " + adminCode 
		+ " " + pwd + " " + name + " " 
		+ telephone + " " + email + " " +
		enrollDate;
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
