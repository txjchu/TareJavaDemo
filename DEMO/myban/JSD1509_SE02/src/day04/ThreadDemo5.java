package day04;
/**
 * 获取线程信息
 * @author Administrator
 *
 */
public class ThreadDemo5 {
	public static void main(String[] args) {
		Thread t= Thread.currentThread();
		
		long id=t.getId();
		System.out.println("线程标识符ID: "+id);
		
		String name=t.getName();
		System.out.println("线程名称name: "+name);
		
		//线程优先级
		int priority=t.getPriority();
		System.out.println("线程优先级priority: "+priority);
		
		System.out.println("线程的状态getState: "+t.getState());
		
		System.out.println("线程是否存活状态isAlive: "+t.isAlive());
		System.out.println("线程是否为守护线程isDaemon: "+t.isDaemon());
		System.out.println("线程是否中断isInterrupted: "+t.isInterrupted());
		
		
	}
}
