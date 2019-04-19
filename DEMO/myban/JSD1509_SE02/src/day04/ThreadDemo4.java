package day04;
/**
 * static Thread currentThread()
 * 
 * 线程提供的该静态方法用来获取运行当前方法的线程。
 * 
 * @author Administrator
 *
 */
public class ThreadDemo4 {
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		System.out.println("运行main方法的线程是："+main);
	
		//main线程调用dosome方法
		dosome();
		
		Thread thread=new Thread(){			//匿名内部类，自动给个名字Thread-0 
			public void run(){
				/*
				 * 当前线程thread调用完start方法后，只要获取了CPU时间片后，
				 * 就会开始执行run方法，所以run方法中获取线程获取的就是thread。
				 * 
				 */
				//查看运行run方法的线程
				Thread t=Thread.currentThread();
				System.out.println("自定义线程："+t);
				
				dosome();			//----谁调用的
			}
		};
		thread.start();
		
	}
	
	public static void dosome(){
		//查看运行当前dosome方法的线程是？
		Thread t=Thread.currentThread();
		System.out.println("运行dosome方法的线程是："+t);
	}
	
	
}

