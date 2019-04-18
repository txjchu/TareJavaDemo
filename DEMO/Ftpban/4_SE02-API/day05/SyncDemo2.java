package day05;
/**
 * 有效的缩小同步范围可以提高并发效率
 * 使用synchronized块来缩小同步范围
 * @author Administrator
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		t1.start();
		t2.start();
	}
}

class Shop{
	public void buy(){
		try{
			Thread t = Thread.currentThread();
			System.out.println(t+"正在挑选衣服...");
			Thread.sleep(5000);
			/*
			 * 使用synchronized块，需要指定
			 * 同步监视器(上锁的对象)
			 * 只要保证多个线程看到得是同一个对象，
			 * 那么就具有同步效果!
			 * 通常使用this就可以。
			 */
			synchronized(this){
				System.out.println(t+"正在试衣服...");
				Thread.sleep(5000);
			}
			
			System.out.println(t+"结账离开");
		}catch(Exception e){
		}
	}
}




