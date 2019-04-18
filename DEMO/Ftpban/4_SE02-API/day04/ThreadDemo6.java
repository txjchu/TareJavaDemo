package day04;
/**
 * 线程优先级
 * 
 * 线程调度的工作不可控，对于线程而言:
 * 1:时间片长短不可控
 * 2:时间片分配给哪个线程不可控
 * 
 * 线程只能被动被分配时间片后并发运行，不能
 * 主动要求获取时间片。
 * 
 * 设置线程优先级可以最大程度的干预线程调度
 * 工作
 * 理论上，线程优先级高的线程分配时间片的次数多。
 * 
 * @author Administrator
 *
 */
public class ThreadDemo6 {
	public static void main(String[] args) {
		Thread min = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("min");
				}
			}
		};
		Thread max = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("max");
				}
			}
		};
		Thread norm = new Thread(){
			public void run(){
				for(int i=0;i<10000;i++){
					System.out.println("norm");
				}
			}
		};		
		min.setPriority(Thread.MIN_PRIORITY);
		max.setPriority(Thread.MAX_PRIORITY);		
		min.start();
		norm.start();
		max.start();
		
	}
}









