package day05;
/**
 * 测试作为集合排序的元素
 * 
 * 由于当前类想使用Collections的sort方法进行
 * 排序，为此必须让当前类付出代价(实现一个接口)
 * 那么我们就认为，sort方法对Point类具有侵入性
 * 在实际开发中是很不理想的。
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
	 * compareTo方法的返回值不关心具体取值，只
	 * 关注取值范围。
	 * 当返回值>0:当前对象(this)比参数对象(o)大
	 * 当返回值<0:当前对象比参数对象小
	 * 当返回值=0:两个对象相等
	 * 
	 */
	public int compareTo(Point o) {
		int len = this.x*this.x+this.y*this.y;
		int olen = o.x*o.x+o.y*o.y;
		return len-olen;
	}
	
}



