package day04.copy;
/**
 * static Thread currentThread()
 * 线程提供的该静态方法用来获取运行当前方法的线程。
 * 
 * String  toString()
 * Thread线程的toString方法，返回的字符串包括：线程名，优先级，线程组。
 * @author Administrator
 *
 */
public class ThreadDemo04 {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("正在运行main方法的线程是："+ mainThread);
		//main线程调用dosome方法
		dosome();
		
		Thread nmthread = new Thread(){
			public void run(){
				/*
				 * 当前线程nmhread调用完start方法后，只要获取了CPU时间片后，就会开始执行run方法，所以
				 * run方法中获取线程获取的就是nmthread。
				 */
				//查看运行run方法的线程
				Thread nmt = Thread.currentThread();
				System.out.println("自定义线程："+ nmt);
				
				dosome();
			}
		};
		nmthread.start();
		
	}
	
	public static void dosome(){
		//查看运行当前dosome方法的线程是
		Thread t = Thread.currentThread();
		System.out.println("运行dosome方法的线程是："+ t);
	}
}














