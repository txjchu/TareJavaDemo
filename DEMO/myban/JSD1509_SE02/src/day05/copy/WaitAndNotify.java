package day05.copy;
/**
 * wait与notify方法是在Object上定义的。用来协调线程同步使用，相比join来讲，
 * 同步的即时性更强。因为join必须等待另一个线程所有工作结束。
 */
public class WaitAndNotify {
	//表示图片是否下载完毕
	public static boolean isFinish;
	
	public static Object obj = new Object();
	
	public static void main(String[] args) {
		//下载线程
		final Thread downLoad = new Thread(){
			public void run(){
				System.out.println("down :开始下载图片...");
				for(int i = 0; i <= 100; i ++){
					System.out.println("down : 图片 "+ i +"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("down : 下载图片完毕！");
				isFinish = true;
				/*
				 * 在这里就可以通知显示线程来显示图片了
				 */
				synchronized(obj){
					obj.notify();//通知，唤醒阻塞的线程
				}
				
				System.out.println("down : 开始下载附件...");
				for(int i = 0; i <= 100; i++){
					System.out.println("down : 附件"+ i +"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("down : 附件下载完毕！");
			}
		};
		
		//显示图片线程
		Thread show = new Thread(){
			public void run(){
				System.out.println("show : 开始显示图片...");
				//应当等待下载小县城将图片下载完毕，调用线程join方法
				try {
					/*
					 * 当一个方法中的局部内部类中，想引用这个方法的其他局部变量或方法参数，那么这个变量或参数必须是final的。
					 */
					
//					downLoad.join();
					synchronized(obj){
						obj.wait();
					}
				} catch (InterruptedException e) {
				}
				if(!isFinish){
					throw new RuntimeException("图片不存在！");
				}
				System.out.println("show : 显示图片完毕！");
			}			
		};
		downLoad.start();
		show.start();
		System.out.println(downLoad.getState().toString());
		System.out.println(show.getState().toString());
	}
}














