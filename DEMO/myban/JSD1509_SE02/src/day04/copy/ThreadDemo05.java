package day04.copy;
/**
 * ��ȡ�̵߳���Ϣ�����API
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
		//�߳����ȼ�
		int priority = t.getPriority();
		System.out.println("t��priority"+ priority);
		
		System.out.println("isAlive:"+ t.isAlive());
		System.out.println("isDaemon�ػ��߳�:"+ t.isDaemon());
		System.out.println("isInterrupted�Ƿ��жϵ�:"+ t.isInterrupted());
		
		
	}
}









