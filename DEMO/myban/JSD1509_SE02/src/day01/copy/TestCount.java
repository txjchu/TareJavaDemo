package day01.copy;
/**
 * ��ϰstatic���δʵ��÷�
 * @author Administrator
 *
 */
public class TestCount {
	
	public static void main(String[] args) {
		Count myCount = new Count();
		TestCount tc = new TestCount();
		int times = 0;
		for(int i = 0; i < 4; i ++){
			increment(myCount, times);//ÿһ��������
			System.out.print(myCount.count +" ");
			System.out.print(times);	   // 0 ??? Ϊʲôtimes�ָֻ���0 
			tc.c(myCount, times);
			System.out.println(" "+ times);// 0 ??? Ϊʲôtimes�ָֻ���0
//			times ++;
//			System.out.println(times);
			
		}
		System.out.println("count is "+ myCount.count);
		System.out.println("times is "+ times);
		
		int a = 3;
		int b = 0; 
		System.out.println( a / b);//�쳣��java.lang.ArithmeticException: / by zero
	}
	public void c(Count c, int times){//temporary ��ʱ����ʱ��
		c.count ++;
		times = times + 4;
		System.out.print("c��"+ times);
	}
	public static void increment(Count c, int times){//����
		c.count ++;
		times = times + 4;
		System.out.println("static��"+ times);
	}
}

//Count��
class Count{
	public int count;
	public Count(int c){//1����������
		count = c;
	}
	public Count(){//�޲ι���
		count = 1;
	}
}