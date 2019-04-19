package day05;
/**
 * 死锁
 * 
 * @author Administrator
 *
 */
public class SyncDemo5 {
	public static void main(String[] args) {
		final DeathLock d = new DeathLock();
		Thread t1 = new Thread(){
			public void run(){
				d.methodA();
				System.out.println(getName()+"运行a方法中......");
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				d.methodB();
				System.out.println(getName()+"运行b方法中......");
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
		synchronized (key1){	//t2在这里等t1释放key1
			Thread t = Thread.currentThread();
			System.out.println(t+"正在运行a方法");
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
			}
			//t1线程只有调用完b方法后才会释放key1
			methodB();
		}
	}
	public void methodB(){
		//t2会将key2对象上锁
		synchronized (key2){	//t1在这等t2释放key2
			Thread t = Thread.currentThread();
			System.out.println(t+"正在调用b方法");
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
			}
			//t2只有调用完a方法后，才会释放key2
			methodA();
			}
		}
	}
	
	
	

