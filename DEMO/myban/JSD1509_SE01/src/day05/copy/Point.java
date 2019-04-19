package day05.copy;
/**
 * 点类
 * 测试作为集合排序的元素
 * 
 * 由于当前类的对象想使用Collections的sort方法进行排序，为此必须让当前类实现一个接口（付出代价），那么
 * 我们就可以认为，sort方法对Point类具有侵入性。
 * 这在实际开发中是很不理想的。
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
	//比较2个点到原点的距离
	public int compareTo(Point o) {
		int len = this.x * this.x + this.y * this.y;
		int olen = o.x * o.x + o.y * o.y;
		return len - olen;
	}
}













