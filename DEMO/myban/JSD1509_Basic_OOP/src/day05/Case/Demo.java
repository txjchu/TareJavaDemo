package day05.Case;
/**
 * 小案例		循环的案例练习
 * @author Administrator
 *
 */
public class Demo {
	public static void main(String[] args) {
		
		byte bMax = Byte.MAX_VALUE;
		byte bMin = Byte.MIN_VALUE;
		System.out.println("byte的：Max:"+ bMax +",Min:"+ bMin);//Max:127,Min:-128
		System.out.println("char的：Max:" + Character.MAX_VALUE +",Min:"+ Character.MIN_VALUE);
		System.out.println("double的：Max:"+ Double.MAX_VALUE +",Min:"+ Double.MIN_VALUE);
		System.out.println("short的：Max:"+ Short.MAX_VALUE +",Min:"+ Short.MIN_VALUE);
		int cMax = Character.MAX_VALUE;
		int cMin = Character.MIN_VALUE;
		System.out.println(cMax +","+ cMin);
		
		System.out.println(Integer.toBinaryString(cMax));
		System.out.println(Integer.toBinaryString(cMin));
		
		//1.数列求和：1+2+3...+10000=?
		int sum = 0;
		for(int i = 0; i <= 10000; i ++){
			sum += i;
		}
		System.out.println(sum);//50005000
		
		//2.阶乘：1*2*3*4...*20=？
		long l = 1;
		for(int i = 1; i <= 20; i ++){//i不能从0开始，0乘以任何数都等于0.
			l *= i;
		}
		System.out.println(l);//2432902008176640000
		
		//3.PI = 4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + 1/13 - 1/15...)
		double s = 0.0;
		for(int i = 1; i < 100000; i +=4){//i的最终取值范围越大，PI的值月精确。
			s += 1.0 / i - 1/(i + 2.0);//注意：自动类型转换。会造成精度缺失，或溢出。
		}
		System.out.println(s);//0.785393163397452
		double PI = 4 * s;
		System.out.println("PI = "+ PI);//PI = 3.141572653589808
		
		//数列求和：9+99+999+...+99..9(n个9)=?
		int n = 3;
		long a = 9;
		long sum1 = a;
		for(int i = 1; i < 3; i++){
			a = a * 10 + 9;
			sum1 += a;
		}
		System.out.println(sum1);//256780503549
	}

}












