package day05.case05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 案例1	
 * @author Administrator
 *
 */
public class TestExecutorService {
	public static void main(String[] args) {
		//创建线程池，指定线程数量为2
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		for(int i = 0; i < 5; i ++){
			Handler handler = new Handler();//创建一个管理者线程对象
			pool.execute(handler);//将Handler线程的对象提交给线程池
		}
		pool.shutdown();//关闭线程池
	}
}
/*
 * 管理者线程	执行每一秒输出一次当前线程的任务
 */
class Handler implements Runnable{
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println("执行当前任务的线程是"+ name);
		for(int i = 0; i < 10; i ++){
			try {
				System.out.println("线程"+ name +"正在运行..."+ i);			
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(name +"出错了!");
				e.printStackTrace();
			}		
		}
		System.out.println("任务完成！");
	}
}
