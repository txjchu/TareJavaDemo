package com.tare.Emp.entity;
/**
 * 	小汽车实体类，封装小汽车相关的字段
 * @author Administrator
 *
 */
public class Car extends Vehicle{
	
	private int doorSize;

	public int getDoorSize() {
		return doorSize;
	}

	public void setDoorSize(int doorSize) {
		this.doorSize = doorSize;
	}

	@Override
	public String toString() {
		return "Car [doorSize=" + doorSize + ", toString()=" + super.toString()
				+ "]";
	}
	
}
