package ioc2;

public class Computer {
	private String mainboard;
	private String hdd;
	
	@Override
	public String toString() {
		return mainboard + " " + hdd;
	}
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
}
