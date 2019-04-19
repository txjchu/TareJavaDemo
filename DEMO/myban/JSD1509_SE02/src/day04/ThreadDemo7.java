package day04;
/**
 * static void sleep(long ms)
 * 使运行当前方法的线程阻塞指定毫秒，超时后，该线程会自动
 * 回到runnable 状态等待再次被分配时间片运行。
 * 
 * @author Administrator
 *
 */
public class ThreadDemo7 {
	public static void main(String[] args) {
		System.out.println("程序开始啦，准备发射！！！！！");
		try{
			/*
			 * 这里会使main 线程阻塞5秒钟。
			 * 在此过程中若其他线程调用了main线程的interruput方法，试图中断main线程时，
			 * sleep 方法会抛出异常。
			 */
			
			Thread.sleep(5000);
			
		}catch(InterruptedException e){
		}
		System.out.println("噗~程序结束了！");
		
		
		
		
	}
}
