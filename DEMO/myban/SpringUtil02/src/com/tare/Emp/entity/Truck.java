package com.tare.Emp.entity;
/**
 * ����ʵ���࣬��װ������ص��ֶΡ�
 * @author Administrator
 *
 */
public class Truck extends Vehicle{
	
	private int boxSize;

	public int getBoxSize() {
		return boxSize;
	}

	public void setBoxSize(int boxSize) {
		this.boxSize = boxSize;
	}

	@Override
	public String toString() {
		return "Truck [boxSize=" + boxSize + ", toString()=" + super.toString()
				+ "]";
	}
	
}
