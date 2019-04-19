package day05.copy;
/**
 * synchronized的互斥锁效果
 * 当使用synchronized对两段代码修饰后，只要锁的对象相同，这两段代码就具有了互斥效果。
 * @author Administrator
 *
 */
public class SyncDemo04 {
	public static void main(String[] args) {
		final Foo f = new Foo();
		Thread t1 = new Thread(){
			public void run(){
				f.methodA();//调用a方法
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				f.methodB();//调用b方法
			}
		};
		t1.start();
		t2.start();
		//观测线程互斥现象
		//当f调用a方法时候，因为a方法和b方法都是同步的，此时因为同一个对象在调用，所以产生了互斥现象，只能一个一个线程运行。
	}	
}

class Foo{
	public synchronized void methodA(){
		Thread t = Thread.currentThread();
		System.out.println(t +"正在调用a方法...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t +"调用a方法完毕！");
	}
	public synchronized void methodB(){
		Thread t = Thread.currentThread();//获取当前线程
		System.out.println(t +"正在调用b方法....");
		try {
			Thread.sleep(5000);//阻塞5秒
		} catch (InterruptedException e) {
		}
		System.out.println(t +"调用b方法完毕！");
	}
}












