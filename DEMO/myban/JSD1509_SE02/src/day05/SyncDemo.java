package day05;
/**
 * 多线程并发安全问题
 * 由于线程钱换的不确定和不可控  ，导致多个线程若操作同一资源时，可能出现严重后果。
 * 为此，想要解决就要将“各干各的（并发）”变为“排队干（）”；
 * 异步变同步。
 * @author Administrator
 *
 */
public class SyncDemo {
	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int bean=table.getBean();
					//模拟在这里正好没有时间了，发生了线程切换
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		Thread t2=new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}	
class Table{
	private int beans=20;
	/*
	 * 当一个方法被synchronized 修饰以后，该方法称为【同步方法】。
	 * 多个线程不能同时进入方法内部执行。
	 * 
	 * 方法上声明synchronized后，上锁的对象就是当前方法所属的对象（this）。
	 * 
	 */
	public synchronized int getBean(){
		if(beans==0){
			throw new RuntimeException("没有豆子了！");
		}
		//模拟在这里正好没有时间了，发生线程切换
		Thread.yield();
		return beans--;
		
	}
}
	

