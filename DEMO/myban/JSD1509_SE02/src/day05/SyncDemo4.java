package day05;
/**
 * synchronized的互斥锁效果。
 * 当使用synchronized对两端代码修饰后，只要锁对象相同，这两段代码就具有了互斥效果。
 * @author Administrator
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
	final Foo foo= new Foo();
	Thread t1 = new Thread(){
		public void run(){
			foo.methodA();
	}
	};	
		Thread t2 = new Thread(){
			public void run(){
				foo.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}

class Foo{
	public synchronized void methodA(){
		Thread t = Thread.currentThread();
		System.out.println(t+"正在调用a方法......");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
		}
		System.out.println(t+"调用a方法完毕！");
	}
	public synchronized void methodB(){
		Thread t=Thread.currentThread();
		System.out.println(t+"正在调用b方法......");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t+"调用b方法完毕！");
	}
}