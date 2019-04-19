package day04.copy;
/**
 * 测试泛型的应用
 * @author Administrator
 *
 */
public class TypeDemo01 {
	public static void main(String[] args) {
		Point01<Integer> p = new Point01<Integer>(1, 2);
		System.out.println(p);//(1,2)
		
		int x = p.getX();
		System.out.println("x:"+ x);//x:1
		
		Point01<Double> p1 = new Point01<Double>(1.1, 2.2);
		double x1 = p1.getX();
		System.out.println("x1:"+ x1);//x1:1.1
		
		Point01<String> p2 = new Point01<String>("一", "二");
		String x2 = p2.getX();
		System.out.println("x2:"+ x2);//x2:一
	}
}










