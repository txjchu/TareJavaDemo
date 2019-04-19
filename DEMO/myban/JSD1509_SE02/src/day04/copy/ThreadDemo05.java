package day04.copy;
/**
 * 获取线程的信息的相关API
 * @author Administrator
 *
 */
public class ThreadDemo05 {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println(t);
		long id = t.getId();
		System.out.println("id:"+ id);
		String name = t.getName();
		System.out.println("name:"+ name);
		//线程优先级
		int priority = t.getPriority();
		System.out.println("t的priority"+ priority);
		
		System.out.println("isAlive:"+ t.isAlive());
		System.out.println("isDaemon守护线程:"+ t.isDaemon());
		System.out.println("isInterrupted是否中断的:"+ t.isInterrupted());
		
		
	}
}









