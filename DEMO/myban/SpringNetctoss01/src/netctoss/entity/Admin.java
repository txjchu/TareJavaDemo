package netctoss.entity;

import java.sql.Timestamp;

/**
 * ����ԱAdminʵ����
 * ÿ����Ա���Էֱ��Ӧ���ݿ��� admin ����ֶΡ�
 * @author Administrator
 *
 */
public class Admin {
	private Integer adminId;	//�˺�id	admin_id
	private String adminCode;  	//�˺�	admin_code
	private String pwd;			//����	�����ֶ���Ϊpassword
	private String name;		//�û�����
	private String telephone;	//�û��绰
	private String email;		//�û�����
	private Timestamp enrollDate;	//timestamp ʱ���		enroll �Ǽ�ע��
	
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
