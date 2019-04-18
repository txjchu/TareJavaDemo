package day02;
/**
 * java中所有的类都直接或间接的继承自Object
 * 编译器在编译源程序时若发现当前类没有使用extends
 * 继承任何类时，就让其直接继承自Object
 * @author Administrator
 *
 */
public class Point {
	private int x;
	private int y;
	
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	/**
	 * 重写Object提供的toString方法
	 * 返回的字符串格式没有具体要求，将来可以按工作
	 * 中的需求而定。但是通常字符串中应当包含需要了解
	 * 当前对象中的属性信息。
	 */
	public String toString(){
		return "(" + x + "," + y + ")";
	}
	/**
	 * 重写Object提供的equals方法。
	 * equals解决的问题是判断两个对象的内容
	 * 是否一样(像不像)。但是equals并不要求
	 * 所有属性值都必须相同，这一切都依靠需求
	 * 而定。关键属性值都一直即可。
	 */
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}
		if(obj instanceof Point){
			Point p = (Point)obj;
			return p.x==this.x&&p.y==this.y;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		Point p = new Point(1,2);
		/*
		 * 若不重写toString()方法，使用的则是
		 * 从Object中继承的，那么返回的字符串
		 * 格式为:类名@地址 。意义不大。
		 * 若需要了解当前对象的信息，则需要重写
		 * 该对象所属类的toString方法。
		 * 
		 */
//		String str = p.toString();
//		System.out.println(str);
		/*
		 * System.out.println(Object obj)
		 * 该方法会将给定的对象的toString()方法
		 * 返回的字符串输出到控制台。
		 */
		System.out.println(p);
		
		
		Point p1 = new Point(1,2);
		/*
		 * 由于引用类型变量中保存的是对象的地址，
		 * ==比较的是值是否相同，所以对于两个
		 * 引用类型变量比较，则是比较地址是否相同
		 * 若相同则表示为同一个对象。
		 * 所以"=="比较的是:是不是同一个
		 */
		System.out.println(p==p1);//false
		/*
		 * 由于Object中的equals方法的比较就是
		 * 使用"=="，所以不重写equals的话，比较
		 * 是没有意义的。
		 */
		System.out.println(p.equals(p1));
	}
}









