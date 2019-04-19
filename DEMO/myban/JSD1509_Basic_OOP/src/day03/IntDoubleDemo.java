package day03;
/**
 * 1.java中取整现象：
 * 并不是四舍五入。
 * 2.double类型数字的运算结果
 * @author Administrator
 *
 */
public class IntDoubleDemo {
	public static void main(String[] args) {
		int a = 10, b = 3;
		System.out.println(a / b);//3
		double a1 = 10, b1 = 3;
		System.out.println(a1 / b1);//3.3333333333333335
		double a2 = 10.0, b2 = 3;
		System.out.println(a2 / b2);//3.3333333333333335
		int c =(int) (a2 / b2);//强制类型转换，将double类型转换为int型
		System.out.println(c);//3
		int a3 = -5;
		double b3 = (double)a3 / 2.0;
		int c1 = a3 >> 1; 
		System.out.println(b3 +" , c1 = "+ c1);//-2.5 , c1 = -3
		System.out.println((int)b3 +", c1 = "+ c1);//-2, c1 = -3	double转换为int型丢失精度。
		
		double i = -5.0;
		int j = (int) i / 2;//-2
		int l = -1 >> 13;//-1的数学移位运算（<<或>>）都无意义
		System.out.println(j +","+ l);//-2,-1
		System.out.println(Double.toHexString(i));//-0x1.4p2	double类型的16进制表达形式
		
		
		double m = 3;
		double n = 2.7;
		System.out.println( m - n);//0.10000000000000009	 2.9
								   //0.2999999999999998		 2.7	
								   //0.2200000000000002      2.78		
	}
}















