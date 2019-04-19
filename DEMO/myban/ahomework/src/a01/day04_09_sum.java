package a01;
//计算数列求和9+99+999+...+9999999999
public class day04_09_sum{
//	public static void main(String[] args) {
//		long a = 1; 
//		long sum = 0;		
//		for(int i = 1; i <= 10; i++){
//			a = a * 10 ;
//			long b = a - 1;
//			sum = sum + b;
//			System.out.println(a +";"+ b);
//			System.out.println(sum);
//			long b = 0;
//			b = a * 10; 
//			long c = 0;
//			c = b - 1;
//			sum += c; 
//		}
//		System.out.println("9+99+999+..+9999999999="+ sum);
//	}
	public static void main(String[] args) {
		long a = 9;
		long sum = a;
		for(int i = 1; i < 3; i++){
			a = a * 10 + 9;
			sum += a;
		}
		System.out.println(sum);
	}
}
