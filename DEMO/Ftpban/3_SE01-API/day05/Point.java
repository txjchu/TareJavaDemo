package day05;
/**
 * ������Ϊ���������Ԫ��
 * 
 * ���ڵ�ǰ����ʹ��Collections��sort��������
 * ����Ϊ�˱����õ�ǰ�ึ������(ʵ��һ���ӿ�)
 * ��ô���Ǿ���Ϊ��sort������Point�����������
 * ��ʵ�ʿ������Ǻܲ�����ġ�
 * @author Administrator
 *
 */
public class Point 
			implements Comparable<Point>{
	private int x;
	private int y;
	
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return "("+x+","+y+")";
	}
	/**
	 * compareTo�����ķ���ֵ�����ľ���ȡֵ��ֻ
	 * ��עȡֵ��Χ��
	 * ������ֵ>0:��ǰ����(this)�Ȳ�������(o)��
	 * ������ֵ<0:��ǰ����Ȳ�������С
	 * ������ֵ=0:�����������
	 * 
	 */
	public int compareTo(Point o) {
		int len = this.x*this.x+this.y*this.y;
		int olen = o.x*o.x+o.y*o.y;
		return len-olen;
	}
	
}



