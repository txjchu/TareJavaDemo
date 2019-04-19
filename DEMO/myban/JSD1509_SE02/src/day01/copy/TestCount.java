package day01.copy;
/**
 * 练习static修饰词的用法
 * @author Administrator
 *
 */
public class TestCount {
	
	public static void main(String[] args) {
		Count myCount = new Count();
		TestCount tc = new TestCount();
		int times = 0;
		for(int i = 0; i < 4; i ++){
			increment(myCount, times);//每一次运行完
			System.out.print(myCount.count +" ");
			System.out.print(times);	   // 0 ??? 为什么times又恢复成0 
			tc.c(myCount, times);
			System.out.println(" "+ times);// 0 ??? 为什么times又恢复成0
//			times ++;
//			System.out.println(times);
			
		}
		System.out.println("count is "+ myCount.count);
		System.out.println("times is "+ times);
		
		int a = 3;
		int b = 0; 
		System.out.println( a / b);//异常：java.lang.ArithmeticException: / by zero
	}
	public void c(Count c, int times){//temporary 临时的暂时的
		c.count ++;
		times = times + 4;
		System.out.print("c的"+ times);
	}
	public static void increment(Count c, int times){//增加
		c.count ++;
		times = times + 4;
		System.out.println("static的"+ times);
	}
}

//Count类
class Count{
	public int count;
	public Count(int c){//1个参数构造
		count = c;
	}
	public Count(){//无参构造
		count = 1;
	}
}