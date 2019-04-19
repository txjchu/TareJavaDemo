package day05.copy;
/**
 * 
 * @author Administrator
 *
 */
public class SyncDemo01 {
	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int been = table.getBeen();
					//模拟此处正好没有时间片了，发生线程切换
					Thread.yield();
					System.out.println("线程1"+ this.getName() +":"+ been);
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				while(true){
					int been = table.getBeen();
					//模拟此处正好没有时间片了，发生了线程切换
					Thread.yield();
					System.out.println("线程2"+ this.getName() +":"+ been);
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}
/**
 * static void yield()
 * 静态方法使当前线程主动让出CPU回到Runnable状态，等待分配时间片。
 * @author Administrator
 *
 */
class Table{
	private int beens = 20;
	/*
	 * 当一个方法被synchronized修饰后，该方法称为同步方法。多个线程不能同时进入方法内部执行。
	 * 方法上声明synchronized后，上锁的对象就是当前方法所属的对象（this）
	 */
	public synchronized int getBeen(){
		if(beens == 0){
			throw new RuntimeException("没有豆子了！");
		}
		//模拟此处正好没有时间片了，发生了线程切换
		Thread.yield();
		System.out.println(Thread.currentThread() +"正在调用...");
		return beens --;
	}
}
















