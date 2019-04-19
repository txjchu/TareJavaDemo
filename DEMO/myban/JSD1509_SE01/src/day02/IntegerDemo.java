package day02;
/**
 * 包装类
 * 对于Java中8个基本类型而言，由于他们是直接以值的形式存在于内存中，
 * 所以没有面向对象的特性。
 * 为了解决它们不能参与面向对象开发的问题，Java为它们提供了对应的包装类。
 * 
 * 其中六个表述数字的包装类都继承自Number类
 * Number是一个抽象类，提供了可以将当前对象表示的数字转换为这6种数字类型的值。
 * 
 * @author Administrator
 *
 */
public class IntegerDemo {
	public static void main(String[] args){
		int a=100000;
		/*
		 * 将基本类型转换为包装类有两种方式：
		 * 1.直接使用构造方法，
		 * 2.使用包装类的静态方法valueOf(推荐）。
		 */
		//1
		Integer i1=new Integer(a);
		
		//2
		Integer i2=Integer.valueOf(a);
		
		System.out.println(i1.equals(i2));
		System.out.println(i1==i2);
		
		/*
		 * valueOf在一些包装类中，会重用内容一样的对象。
		 * 但是new是一定要创建新对象的。
		 */
		//将包装类的内容转换为int值
		int n=i1.intValue();//------value?老错
		System.out.println(n);
		
		//将包装类的内容转换为double值
		double d=i1.doubleValue();
		System.out.println(d);
	}		
//		
//		dosome("abc");
//		dosome(new Point(1,2));
//		int a=1+1;
//		dosome(a);

	
	public static void dosome(Object o){
		
	}
}
//class Integer{
//	private int i;
//	
//	public Integer(int i){
//		this.i=i;
//	}

