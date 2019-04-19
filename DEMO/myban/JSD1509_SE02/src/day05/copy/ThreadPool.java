package day05.copy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池：
 * 作用	1.控制线程数量
 * 		2.重用线程
 * 
 * 当我们有大量任务需要运行时，就要考虑使用线程池。
 * 当我们的程序频繁的创建线程销毁线程时，也要使用线程池。
 * @author Administrator
 *
 */
public class ThreadPool {
	public static void main(String[] args) {
		//创建一个含有2条线程的固定现场池
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		for(int i = 0; i < 5; i ++){
			Runnable runn = new Runnable(){
				@Override
				public void run() {
					Thread t = Thread.currentThread();
					System.out.println("线程"+ t +"正在执行任务...");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println("线程被中断了！");
					}
					System.out.println("线程"+ t +"运行任务完毕！");
				}				
			};
			//将任务指派给线程池
			threadPool.execute(runn);
			System.out.println("将线程"+ runn +"提交给了线程池...");
		}
		//所有任务指派完毕
		System.out.println("所有任务指派给线程池完毕！");
		
		System.out.println("关闭线程池....");
		threadPool.shutdownNow();//立即关闭线程池，不管是否还有正在Runnable或Running的线程。
//		threadPool.shutdown();//关闭线程池，正在Running执行的线程会继续执行完毕
	}
}






















