package di;
/**
 * 
 * @author Administrator
 *
 */
public class Computer {
	private String mainboard;//----����
	private String hdd;//----�ڴ�
	
	//toString()�������Զ����ɡ���������ԡ�
	@Override
	public String toString() {
		return mainboard+","+hdd;//----��ӡ�����壬�ڴ����Ϣ��
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
