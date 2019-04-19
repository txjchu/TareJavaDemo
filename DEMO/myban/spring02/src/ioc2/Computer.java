package ioc2;
/**
 * 演示：注入对象
 */
import java.io.Serializable;

public class Computer implements Serializable {
	private String mainboard;
	private String hdd;
	
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
	@Override
	public String toString() {
		//加上toString()方法，用来打印其信息
		return mainboard+","+hdd;
	}
	
}
