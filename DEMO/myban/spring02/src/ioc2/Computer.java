package ioc2;
/**
 * ��ʾ��ע�����
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
		//����toString()������������ӡ����Ϣ
		return mainboard+","+hdd;
	}
	
}
