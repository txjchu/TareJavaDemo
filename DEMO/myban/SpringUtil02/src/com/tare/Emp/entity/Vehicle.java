package com.tare.Emp.entity;

/**
 * ��ͨ����ʵ���࣬��װt_car���ݱ��еĹ����ֶΡ�
 * @author Administrator
 *
 */
public class Vehicle {
	private int id;
	private String type;
	private String color;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", type=" + type + ", color=" + color
				+ "]";
	}
	
	
}
