package org.tare.ioc;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
/**
 * 课后练习1：配置方式注入集合
 * @author Administrator
 *
 */
public class MessageBean implements Serializable {
	
	private String name;
	private int age;
	
	private List<String> list;
	private Set<String> set;
	private Map<String, Object> map;
	private Properties props;
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
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Set getSet() {
		return set;
	}
	public void setSet(Set set) {
		this.set = set;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	
	public void execute(){
		System.out.println("基本值：");
		System.out.println(name);
		System.out.println(age);
		System.out.println("集合：");
		System.out.println("编程语言：");
		for(String l : list){
			System.out.println(l);
		}
		System.out.println("城市:");
		for(String s : set){
			System.out.println(s);
		}
		System.out.println("分数:");
		Set<String> keys =  map.keySet();//从map中获取key的Set集合
		for(String key : keys){
			System.out.println(key +"=="+ map.get(key));
		}
		System.out.println("参数对：");
		Set<Object> objs = props.keySet();//获取props中的key的Set集合
		for(Object o : objs){
			System.out.println(o +"="+ props.get(o));
		}
	}
}
