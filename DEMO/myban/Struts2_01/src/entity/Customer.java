package entity;

import java.util.List;

/**
 * �˿�ʵ���ࣺ
 * day04������ϰStruts2��UI��ǩ�÷�
 * @author Administrator
 *
 */
public class Customer {
	private String name;//����
	private String password;//����
	private String desc;//���
	private boolean marry;//�Ƿ����
	private String sex;//�Ա�
	private List<String> travelCities;//ȥ���ĳ���
	private String home;//����
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public boolean isMarry() {
		return marry;
	}
	public void setMarry(boolean marry) {
		this.marry = marry;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public List<String> getTravelCities() {
		return travelCities;
	}
	public void setTravelCities(List<String> travelCities) {
		this.travelCities = travelCities;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	
	
}
