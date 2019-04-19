package org.tare.ioc;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
/**
 * �κ���ϰ1�����÷�ʽע�뼯��
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
		System.out.println("����ֵ��");
		System.out.println(name);
		System.out.println(age);
		System.out.println("���ϣ�");
		System.out.println("������ԣ�");
		for(String l : list){
			System.out.println(l);
		}
		System.out.println("����:");
		for(String s : set){
			System.out.println(s);
		}
		System.out.println("����:");
		Set<String> keys =  map.keySet();//��map�л�ȡkey��Set����
		for(String key : keys){
			System.out.println(key +"=="+ map.get(key));
		}
		System.out.println("�����ԣ�");
		Set<Object> objs = props.keySet();//��ȡprops�е�key��Set����
		for(Object o : objs){
			System.out.println(o +"="+ props.get(o));
		}
	}
}
