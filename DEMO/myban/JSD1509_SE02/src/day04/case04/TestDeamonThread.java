package day04.case04;
/**
 * 案例5
 * 测试守护线程（后台线程）
 * @author Administrator
 *
 */
public class TestDeamonThread {
	public static void main(String[] args) {
		//设置一个后台线程
		Thread deamon = new Thread(){
			public void run(){
				while(true){
					System.out.println("后台线程");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}					
				}
			}
		};
		deamon.setDaemon(true);//设置为后台线程
		deamon.start();
		
		//main线程
		Thread t1 = Thread.currentThread();
		try {
			t1.sleep(5000);//当前线程main线程进入阻塞
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//进程中所有的前提线程结束后，所有的后台线程都会结束
		System.out.println("main线程结束了!");
	}
}
