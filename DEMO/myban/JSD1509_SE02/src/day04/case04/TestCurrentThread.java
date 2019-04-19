package day04.case04;
/**
 * 案例3
 * 测试Thread类的  Thread  currentThread()方法
 * @author Administrator
 *
 */
public class TestCurrentThread {
	public static void main(String[] args) {
		System.out.println("运行main方法的线程是："+ Thread.currentThread());
		testCurrent();
		Thread t = new Thread(){
			public void run(){
				System.out.println("线程t:"+ Thread.currentThread());
				testCurrent();
			}
		};
		t.start();
	}
	
	/*
	 * 不同的线程调用该方法，获取当前线程的输出
	 */
	public static void testCurrent(){
		System.out.println("正在运行的线程是："+ Thread.currentThread());
	}
}
