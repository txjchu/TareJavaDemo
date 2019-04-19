package day05.copy;
/**
 * 静态方法上使用synchronized.
 * synchronized修饰静态方法后，上锁对象为当前类对象。
 * 类对象：Class类型的实例，JVM在加载任何一个类时，都会创建一个Class类型的实例描述该类，所以每个类都
 * 有且只有一个Class的实例描述它。synchronized在静态方法中就是给这个Class实例上锁的。
 * 所以，多个线程无论何时何地调用同一个静态方法时，都具有同步效果。
 * 
 * 反射
 * @author Administrator
 *
 */
public class SyncDemo03 {
	public static void main(String[] args) {
		final SyncDemo03 d1 = new SyncDemo03();
		final SyncDemo03 d2 = new SyncDemo03();
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
	
	public static synchronized void dosome(){//静态的同步方法
		Thread t = Thread.currentThread();
		System.out.println(t +"正在调用dosome方法...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t +"调用dosome完毕！");
	}
}













