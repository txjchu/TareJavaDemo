package org.tarena.entity;

import java.io.Serializable;

public class Emp implements Serializable{
	
	private String name;
	private int no;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
}
