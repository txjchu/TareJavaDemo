package day05.copy;
/**
 * ��һ�����ʵ����ΪMap��keyʹ��ʱ��������������hashcode()��equals()�Ľ����Ӱ��HashMap�ļ���Ч�ʡ�
 * ������key��hashcode()ֵ��ͬ������equals�Ƚ�ȴ��ͬ�������HashMap�в������������������ı����Ƚ�����
 * ������������Ԫ����Map�зǳ���Ļ�����ô������Ӱ��HashMap�Ĳ�ѯЧ�ʡ�
 * ����һ�����hashcode() ��equals()����Ӧ���ɶ���д����ע������⡣
 * �ɶ���д��׼��
 * 1.��������дһ�����equals����ʱ����Ӧ��һ����дhashcode()������
 * 2.һ���ԣ����������������equals()�ȽϽ��Ϊtrueʱ����ôhashCode()�������ص�����Ӧ����ȡ�
 * 3.hashCode()�������ص�����Ӧ����һ���ȶ���ֵ����ε��ø÷������ص�����Ӧ����ͬ�����ǲ���equals()�Ƚϵ�����ֵ�����˸ı䡣
 * 4.���������hashCode()ֵ����ͬ����equals()�ȽϵĽ��ҲҪ��ͬ������ͬ�����Ӱ��HashMap�����ܡ� 
 * @author Administrator
 *
 */
public class Key01 {
	private int x;
	private int y;
	public Key01(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key01 other = (Key01) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
	
}















