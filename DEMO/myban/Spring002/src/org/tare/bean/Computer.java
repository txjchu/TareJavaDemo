package org.tare.bean;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 *
 */
public class Computer implements Serializable{
	private String mainboard;//Ö÷°å
	private String hdd;//Ó²ÅÌ
	private String ram;//ÄÚ´æ
	public String getMainboard() {
		return mainboard;
	}
	public void setMainboard(String mainboard) {
		this.mainboard = mainboard;
	}
	public String getHdd() {
		return hdd;
	}
	public void setHdd(String hdd) {
		this.hdd = hdd;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	@Override
	public String toString() {
		return "Computer [mainboard=" + mainboard + ", hdd=" + hdd + ", ram="
				+ ram + "]";
	}
	
	
	
}
