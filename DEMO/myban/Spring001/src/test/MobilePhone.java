package test;
/**
 * 用于练习构造器注入
 * @author Administrator
 *
 */
public class MobilePhone {
	private String cpu;
	private String ram;
	
	public MobilePhone(String cpu, String ram) {
		this.cpu = cpu;
		this.ram = ram;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "MobilePhone [cpu=" + cpu + ", ram=" + ram + "]";
	}
	
}
