package org.tare.ioc;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 用来练习@Autowired/@Qualifier注解，指定依赖关系
 * @author Administrator
 *
 */
@Component("cp")
public class Computer implements Serializable{
	private String mainboard;//主板
	private String hdd;//硬盘
	private String ram;//内存
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
