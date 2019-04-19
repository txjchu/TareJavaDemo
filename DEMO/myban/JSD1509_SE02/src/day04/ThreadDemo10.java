package day04;
/**
 * void join()
 * 该方法会阻塞调用当前方法的线程，并在join所属对象线程上等待，直到该线程完成工作，
 * 当前线程才会接触阻塞继续向下执行。
 * 
 * 例如：
 * a线程调用了b线程的方法：b.join()
 * 那么a线程就进入了阻塞状态，直到b线程执行完毕，a线程才会接触join阻塞，继续执行。
 * 
 * join方法是为了解决线程间同步工作的。
 * 
 * @author Administrator
 *
 */
public class ThreadDemo10 {
	//表示图片是否下载完毕
	public static boolean isFinish;	
	
	public static void main(String[] args) {
		//下载线程
		final Thread download= new Thread(){		//要求download必须final
			public void run(){
				System.out.println("down:开始下载图片...");
				for(int i = 0; i <= 100; i ++){
					System.out.println("down : 加载"+ i + "%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("down : 图片加载完毕！");
				isFinish = true;//将图片完成状态改为true
			}
		};
		
		//显示图片线程
		Thread show = new Thread(){
			public void run(){
				System.out.println("show : 开始显示图片...");
				try {
					/**
					 * 当在一个方法中的局部内部类中，想引用这个方法的其他局部变量或方法参数，那么这个变量或者方法参数
					 * 必须是final修饰的。
					 */
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(!isFinish){
					throw new RuntimeException("图片不存在！");
				}
				System.out.println("show : 图片显示完毕！");
			}
		};
		
		download.start();
		show.start();
		
		
	}
}












