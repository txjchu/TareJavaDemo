package day05.case05;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 案例2	BlockingQueue
 * @author Administrator
 *
 */
public class TestBlockingQueue {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);//创建双端缓冲队列
		for(int i = 0; i < 20; i ++){
			try {
				boolean b = queue.offer(i, 5, TimeUnit.SECONDS);//每5秒向队列中添加一次元素 
				System.out.println("第"+ i +"次存入元素是否成功："+ b);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		//按指定时间读取队列中元素
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(10);//创建双端缓冲队列
		for(int i = 0; i < 10; i ++){
			queue.offer(i);
		}
		for(int i = 0; i < 20; i ++){
			try {
				Integer b = queue.poll(5, TimeUnit.SECONDS);
				System.out.println("第"+ i +"次读取到的元素是："+ b);
			} catch (InterruptedException e) {
				System.out.println();
				e.printStackTrace();
			}
		}
		
	}
}












