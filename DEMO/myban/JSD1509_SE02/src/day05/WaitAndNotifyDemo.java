package day05;
/**
 * wait与notify方法是在Object  上定义的。
 * 用来协调线程同步使用，相比join 来讲，同步的即时性更强。因为join必须等待
 * 另一个线程所有工作都结束。
 * @author Administrator
 *
 */
public class WaitAndNotifyDemo {
	//表示图片是否下载完毕
	public static boolean isFinish;
	
	public static Object obj = new Object();
	
	public static void main(String[] args){
		//下载线程
		final Thread download = new Thread(){
			public void run(){
				System.out.println("down:开始下载......");
				for(int i=0;i<=100;i++){
					System.out.println("down:"+i+"%");
					try{
						Thread.sleep(50);
					}catch(InterruptedException e){
					}
					}
				System.out.println("down:图片下载完毕！");
				isFinish=true;//----------
				/*
				 * 在这里就可以通知显示线程来显示图片了。
				 */
				synchronized(obj){
				obj.notify();
				}
			}
			};
			//显示图片线程：
			Thread show = new Thread(){
				public void run(){
					System.out.println("show:开始显示图片...");
					//应当等待下载线程将图片下载完毕
					try{
						/*
						 * 当一个方法中的局部内部类中
						 * 想引用这个方法的其他局部变量或方法参数，
						 * 那么这个变量或参数必须是final的。
						 */
						
//						download.join();
						
						/*
						 * 该方法会导致show线程进入阻塞状态，直到obj.notify 被调用才会解除。
						 */
						obj.wait();
					}catch(InterruptedException e){
					}
				if(!isFinish){
					throw new RuntimeException("图片不存在！");
				}
				System.out.println("shwo:图片显示完成！");
				}
				
			};
		download.start();
		show.start();
	}
}

