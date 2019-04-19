package day04.copy;
/**
 * static void sleep(long ms)
 * 使运行当前方法的线程阻塞指定毫秒，超时后，该线程会自动回到runnable状态等待再次被分配时间片运行。
 * @author Administrator
 *
 */
public class ThreadDemo07 {
	public static void main(String[] args) {
		System.out.println("程序开始了!");
		try {
			Thread.sleep(5000);//阻塞5000毫秒
			/*
			 * 这里会使main线程阻塞5000毫秒，在次过程中若其他线程调用了main线程的interrupt方法试图中断
			 * main线程时，sleep方法会抛出异常。
			 */
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("程序结束了！");
	}
}















