package day05;
/**
 * 静态方法上使用synchronized.
 * synchronized修饰静态方法后，上锁对象为
 * 当前类对象。
 * 类对象:Class类型的实例，JVM在加载任何一个类时，
 * 都会创建一个Class类型的实例来描述该类，所以每个
 * 类都有且只有一个Class的实例描述它。synchronized
 * 在静态方法中就是给这个Class实例上锁。
 * 所以，多个线程无论何时何地调用同一个静态方法时，
 * 都具有同步效果。
 * 
 * 反射
 * @author Administrator
 *
 */
public class SyncDemo3 {
	public static void main(String[] args) {
		final SyncDemo3 d1 = new SyncDemo3();
		final SyncDemo3 d2 = new SyncDemo3();
		Thread t1 = new Thread(){
			public void run(){
				d1.dosome();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				d2.dosome();
			}
		};
		t1.start();
		t2.start();
	}
	
	public synchronized static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println(t+"正在调用dosome方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t+"调用dosome完毕!");
	}
}


