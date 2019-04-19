package day02;
/**
 * java中所有的类都直接或间接的继承自Object。编译器在编译源程序时若发现当前类没有使用extends继承任何类时，
 * 就让其直接继承自Object
 * @author Administrator
 *
 */
public class Point01 {
	private int x;
	private int y;
	
	public Point01(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 重写Object提供的toString方法 constructor
	 * 返回的字符串格式没有具体要求，将来可以按照工作中的实际需求而定。但是通常字符串中应当包含需要了解当前对象中的属性信息。
	 */
	
	public String toString(){
		return "(" + x +","+ y +")";
	}
	
	/**
	 * 重写Object提供的equals方法。
	 * equals解决的问题是判断两个对象的内容是否一样（像不像）。但是equals并不要求所有属性值都必须相同，
	 * 这一切都依靠需求而定。关键属性都一致即可。
	 * equals()方法三个原则：
	 * 1.任何对象和Null比较，都返回false;
	 * 2.同一个对象equals比较，应该恒等于true;
	 * 3.两个对象不属于同一个类时，应返回false.
	 */
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}
		if(obj instanceof Point01){
			Point01 p = (Point01) obj;
			return p.x == this.x && p.y == this.y;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Point01 p = new Point01(1, 2);
		String str = p.toString();
		System.out.println(p);//该方法会将给定对象的toString()方法的返回的字符串输出到控制台。//(1,2)
		System.out.println(str);//(1,2)
		
		Point01 p1 = new Point01(1,2);
		System.out.println(p == p1);//false
		/*
		 * 由于Object中的equals方法的比较就是使用“==”，所以不重写equals()方法的话，比较是没有意义的。
		 */
		System.out.println(p.equals(p1));//true
	}
}













