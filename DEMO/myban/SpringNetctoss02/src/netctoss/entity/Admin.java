package netctoss.entity;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 数据表admin的实体类
 * @author Administrator
 *
 */
public class Admin implements Serializable{
	private Integer adminId;
	private String adminCode;
	private String pwd;
	private String name;
	private String telephone;
	private String email;
	private Timestamp enrollDate;
	

	
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminCode=" + adminCode
				+ ", pwd=" + pwd + ", name=" + name + ", email=" + email
				+ ", telephone=" + telephone + ", enrollDate=" + enrollDate
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
