package ioc2;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MessageBean implements Serializable {
	//基本类型注入
	private String name;
	private int age;	
	//对象注入
	private Computer computer;
	//集合注入
	private List<String> langs;
	private Set<String> cities;
	//Map
	private Map<String,String> score;//----score分数，得分，成绩
	//properties----性能，配置文件
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
		System.out.println("computer:"+computer);	//打印出computer的方法。【】?为什么和打印name,age方式不一样----自带toString()方法。
		System.out.println("langs:"+langs);		//集合自带toString()方法，不需要遍历
		System.out.println("cities:"+cities);
		System.out.println("score:"+score);
		System.out.println("properties:"+dbinfo);
	}
}
