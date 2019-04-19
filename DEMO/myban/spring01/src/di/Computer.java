package di;
/**
 * 
 * @author Administrator
 *
 */
public class Computer {
	private String mainboard;//----主板
	private String hdd;//----内存
	
	//toString()方法，自动生成。常用语测试。
	@Override
	public String toString() {
		return mainboard+","+hdd;//----打印出主板，内存的信息。
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
