package day04.copy;
/**
 * void join()
 * 该方法会阻塞调用当前方法的线程，并在join所属的对象线程上等待，直到该线程完成工作，当前线程才会解除阻塞继续向下执行。
 * 例如：
 * a线程调用了b线程的方法：b.join()
 * 那么a线程 就进入了阻塞状态，直到b线程执行完毕，a现场称才会解除join阻塞，继续执行。
 * 
 * join方法是为了解决线程间同步工作的。
 * @author Administrator
 *
 */
public class ThreadDemo10 {
	//表示图片是否下载完毕
	public static boolean isFinish;
	
	public static void main(String[] args) {
		//下载线程
		final Thread download = new Thread(){
			public void run(){
				System.out.println("down:开始下载图片...");
				for(int i = 0; i <= 100; i ++){
					System.out.println("down : "+ i +"%");
					try {
						Thread.sleep(50);//阻塞50毫秒
					} catch (Exception e) {
					}
				}
				System.out.println("down : 图片加载完毕!");
				isFinish = true;
			}
		};
		
		//显示图片线程
		Thread show = new Thread(){
			public void run(){
				System.out.println("show : 开始显示图片...");
				//应当等待下载图片线程将图片下载完毕
				/*
				 * 若一个方法中的局部内部类想引用这个方法的其他局部变量或方法参数，那么这个变量或参数必须是final的。
				 */
				try {
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(!isFinish){
					throw new RuntimeException("图片不存在！");
				}
				System.out.println("show : 显示图片完毕!");
			}
		};
		
		download.start();
		show.start();
	}
}











