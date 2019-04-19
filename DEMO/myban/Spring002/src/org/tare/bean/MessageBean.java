package org.tare.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class MessageBean {
	//������������
	private String name;
	private int age;
	//bean����
	private Computer computer;
	//����
	private List<String> langs;
	private Set<String> cities;
	private Map<String, Object> score;//�÷�
	private Properties props;
	
	public void execute(){
		System.out.println("����ֵ��");
		System.out.println(name);
		System.out.println(age);
		System.out.println("bean����");
		if(computer != null){
			System.out.println(computer.getMainboard());
			System.out.println(computer.getHdd());
			System.out.println(computer.getRam());
		}
		System.out.println("������ԣ�(List����)");
		if(langs != null){
			for(String lang : langs){
				System.out.println(lang);
			}
		}
		System.out.println("���У�(Set����)");
		if(cities != null){
			for(String city : cities){
				System.out.println(city);
			}
		}
		System.out.println("����:(Map)");
		if(score != null){
			Set<String> set = score.keySet();//��Mapת��ΪSet
			for(String key : set){
				System.out.println(key +" : "+ score.get(key));
			}
		}
		System.out.println("������(properties)");
		if(props != null){
			Set<Object> propKeySet = props.keySet();//��properties����ת��ΪSet����
			for(Object key : propKeySet){
				System.out.println(key +" : "+ props.getProperty((String) key));
			}
		}
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

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public List<String> getLangs() {
		return langs;
	}

	public void setLangs(List<String> langs) {
		this.langs = langs;
	}

	public Set<String> getCities() {
		return cities;
	}

	public void setCities(Set<String> cities) {
		this.cities = cities;
	}

	public Map<String, Object> getScore() {
		return score;
	}

	public void setScore(Map<String, Object> score) {
		this.score = score;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}
	
	
}
