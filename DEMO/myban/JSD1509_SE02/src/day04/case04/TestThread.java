package day04.case04;

import org.junit.Test;

/**
 * 案例
 * @author Administrator
 *
 */
public class TestThread {
	
	/*
	 * 测试多线程并发
	 */
	@Test
	public void test(){
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		t1.start();
		t2.start();
	}
}

/*
 * 自定义线程
 */
class MyThread extends Thread{

	@Override
	public void run() {
		for(int i = 0; i <= 100; i += 2){
			System.out.println(Thread.currentThread() +","+ i);
		}
	}
	
}















