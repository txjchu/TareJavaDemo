package com.tare.Emp.entity;
/**
 * 	С����ʵ���࣬��װС������ص��ֶ�
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
