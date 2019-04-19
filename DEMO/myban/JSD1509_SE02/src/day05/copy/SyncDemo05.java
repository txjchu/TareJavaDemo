package day05.copy;
/**
 * 死锁现象
 * @author Administrator
 *
 */
public class SyncDemo05 {
	public static void main(String[] args) {
		final DeathLock d = new DeathLock();
		Thread t1 = new Thread(){
			public void run(){
				d.methodA();
				System.out.println(this.getName() +"调用完a方法了！");
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				d.methodB();
				System.out.println(this.getName() +"调用完b方法了!");
			}
		};
		
		t1.start();
		t2.start();
	}
}

class DeathLock{
	//两个锁对象
	Object key1 = new Object();
	Object key2 = new Object();
	
	public void methodA(){
		//t1线程将key1锁住
		synchronized(key1 ) {
			Thread t = Thread.currentThread();//获取当前线程
			System.out.println(t +"正在运行a方法...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			System.out.println(t +"运行a方法完毕！");
			
			//此处线程t1只有调用完b方法才会释放key1
			methodB();
		}
	}
	
	public void methodB(){
		//t2线程将key2锁住
		synchronized(key2){
			Thread t = Thread.currentThread();
			System.out.println(t +"正在调用b方法....");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			System.out.println(t +"运行b方法完毕！");
			
			//此处线程t2只有调用完a方法才能释放key2
			methodA();
		}
	}
}












