package org.tare.entity;
/**
 * 练习联动下拉选，使用JSON传输数据
 * @author Administrator
 *
 */
public class City {
	private String name;
	private String value;
	public City(){
		
	}
	public City(String cityName, String cityValue) {
		this.name = cityName;
		this.value = cityValue;
	}
	public String getName() {
		return name;
	}
	public void setName(String cityName) {
		this.name = cityName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String cityValue) {
		this.value = cityValue;
	}
	@Override
	public String toString() {
		return "City [cityName=" + name + ", cityValue=" + value + "]";
	}
	
}
