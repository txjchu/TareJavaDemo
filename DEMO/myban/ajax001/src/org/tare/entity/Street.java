package org.tare.entity;

import java.io.Serializable;

/**
 * 练习三级联动下拉选的实体类
 * @author Administrator
 *
 */
public class Street implements Serializable{
	private String name;
	private String value;
	public Street(){
		
	}
	
	public Street(String name, String value) {
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Street [name=" + name + ", value=" + value + "]";
	}
	
}
