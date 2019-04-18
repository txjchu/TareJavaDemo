package day04;
/**
 * 获取线程信息的相关API
 * @author Administrator
 *
 */
public class ThreadDemo5 {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		
		long id = t.getId();
		System.out.println("id:"+id);
		
		String name = t.getName();
		System.out.println("name:"+name);
		//线程优先级
		int priority = t.getPriority();
		System.out.println("priority:"+priority);
		
		System.out.println("isAlive:"+t.isAlive());
		System.out.println("isDaemon:"+t.isDaemon());
		System.out.println("isInterrupted:"+t.isInterrupted());
		
	}
}








