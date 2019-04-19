package day05.case05;

import java.util.concurrent.BlockingQueue;

/**
 * 课后习题	播放类 ===== 消费者  演示双端队列可以同时存取
 * @author Administrator
 *
 */
public class Player implements Runnable {
	//双端缓冲队列
	private BlockingQueue queue;
	//构造器
	public Player(BlockingQueue q){
		this.queue = q;
	}
	@Override
	public void run() {
		try {
			while(true){
				consume(queue.take());
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	//消费方法	即从队列中取出元素
	public void consume(Object o){//consume 消费
		System.out.println("播放视频"+ o);
	}
	
	
	
	
}
