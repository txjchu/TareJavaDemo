package day05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池：
 * 主要解决两个问题
 * 1:控制线程数量
 * 2:重用线程
 * 
 * 当我们有大量任务需要运行时，就要考虑使用线程池
 * 当我们的程序频繁的创建线程销毁线程时，也要使用线程池
 * 
 * 
 * @author Administrator
 *
 */
public class ThreadPool {
	public static void main(String[] args) {
		//创建一个含有2条线程的固定线程池
		ExecutorService threadPool
			= Executors.newFixedThreadPool(2);
		
		for(int i=0;i<5;i++){
			Runnable runn = new Runnable(){
				public void run(){
					Thread t = Thread.currentThread();
					System.out.println(t+"正在执行任务..");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println("线程被中断了!");
					}
					System.out.println(t+"运行任务完毕!");
				}
			};
			//将任务指派给线程池
			threadPool.execute(runn);
		}
		//所有任务指派完毕
		System.out.println("所有任务指派完毕");
		
		System.out.println("关闭线程池...");
		threadPool.shutdownNow();
		
	}
}







