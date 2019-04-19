package ioc2;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MessageBean implements Serializable {
	//��������ע��
	private String name;
	private int age;	
	//����ע��
	private Computer computer;
	//����ע��
	private List<String> langs;
	private Set<String> cities;
	//Map
	private Map<String,String> score;//----score�������÷֣��ɼ�
	//properties----���ܣ������ļ�
	private Properties dbinfo;
	
	public Properties getDbinfo() {
		return dbinfo;
	}
	public void setDbinfo(Properties dbinfo) {
		this.dbinfo = dbinfo;
	}
	public Map<String, String> getScore() {
		return score;
	}
	public void setScore(Map<String, String> score) {
		this.score = score;
	}
	public Set<String> getCities() {
		return cities;
	}
	public void setCities(Set<String> cities) {
		this.cities = cities;
	}
	public List<String> getLangs() {
		return langs;
	}
	public void setLangs(List<String> langs) {
		this.langs = langs;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void showInfo(){
		System.out.println("name:"+name+"age:"+age);	
		System.out.println("computer:"+computer);	//��ӡ��computer�ķ���������?Ϊʲô�ʹ�ӡname,age��ʽ��һ��----�Դ�toString()������
		System.out.println("langs:"+langs);		//�����Դ�toString()����������Ҫ����
		System.out.println("cities:"+cities);
		System.out.println("score:"+score);
		System.out.println("properties:"+dbinfo);
	}
}
