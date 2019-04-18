package day04;
/**
 * 测试泛型的使用
 * @author Administrator
 *
 */
public class TypeDemo1 {
	public static void main(String[] args) {
		Point<Integer> p = new Point<Integer>(1,2);
		System.out.println(p);
		
		int x = p.getX();
		System.out.println("x:"+x);
		
		Point<Double> p1 = new Point<Double>(1.1,2.2);
		double x1 = p1.getX();
		System.out.println("x1:"+x1);
		
		Point<String> p2 = new Point<String>("一","二");
		String x2 = p2.getX();
		System.out.println("x2:"+x2);
		
	}
}



