package day05.case05;

import java.util.concurrent.BlockingQueue;

/**
 * 课后习题	下载类 ==== 生产者	演示双端缓冲队列可以同时存取线程。
 * 
 * 总结： 1.设定一个方法，用来控制线程的阻塞，然后在run方法里重复调用。即将双端缓冲线程队列的操作，与对线程阻塞的操作分离开。
 * 	   2.双端缓冲队列put/take，pull/push，存取的4种方法，有阻塞性
 * 	   3.方法返回值为Object
 * 	   4.BlockingQueue中存放着生产方法produce()的返回值Object.双端缓冲队列允许两条线程同时进行存、取工作。
 * @author Administrator
 *
 */
public class Download implements Runnable{
	
	//双端缓冲队列
	private BlockingQueue queue;
	//构造器
	public Download(BlockingQueue q){
		this.queue = q;
	}
	
	@Override
	public void run() {
		try {
			while(true){
				System.out.println("下载视频数据"+ index);
				queue.put(produce());//将该线程放入双端缓冲队列
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	} 
	
	//睡眠
	int index = 0;
	public Object produce(){
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "下载视频"+ index++;
	}
	
}
