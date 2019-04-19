package day05.copy;
/**
 * ����
 * ������Ϊ���������Ԫ��
 * 
 * ���ڵ�ǰ��Ķ�����ʹ��Collections��sort������������Ϊ�˱����õ�ǰ��ʵ��һ���ӿڣ��������ۣ�����ô
 * ���ǾͿ�����Ϊ��sort������Point����������ԡ�
 * ����ʵ�ʿ������Ǻܲ�����ġ�
 * @author Administrator
 *
 */
public class Point implements Comparable<Point>{
	private int x ;
	private int y;
	public Point(int x, int y){
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
	public String toString() {
		return x +","+ y;
	}

	@Override
	//�Ƚ�2���㵽ԭ��ľ���
	public int compareTo(Point o) {
		int len = this.x * this.x + this.y * this.y;
		int olen = o.x * o.x + o.y * o.y;
		return len - olen;
	}
}













