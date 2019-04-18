package entity;

import java.io.Serializable;

public class User implements Serializable {

	private String userName;
	private String password;
	private String sex;
	private String[] loves;
	private Course course;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String[] getLoves() {
		return loves;
	}
	public void setLoves(String[] loves) {
		this.loves = loves;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
}





