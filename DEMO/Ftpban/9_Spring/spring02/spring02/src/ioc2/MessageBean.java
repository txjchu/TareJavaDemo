package ioc2;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MessageBean {
	private String name;
	private int age;
	private Computer computer;
	private List<String> langs;
	private Set<String> cities;
	private Map<String,String> score;
	private Properties dbinfo;
	public Map<String, String> getScore() {
		return score;
	}
	public void setScore(Map<String, String> score) {
		this.score = score;
	}
	public Properties getDbinfo() {
		return dbinfo;
	}
	public void setDbinfo(Properties dbinfo) {
		this.dbinfo = dbinfo;
	}
	public Computer getComputer() {
		return computer;
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
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	public void showInfo(){
		System.out.println(
				"name:" + name + " age:" + age);
		System.out.println("computer:" + computer);
		System.out.println("langs:" + langs);
		System.out.println("cities:" + cities);
		System.out.println("score:" + score);
		System.out.println("dbinfo:" + dbinfo);
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
}
