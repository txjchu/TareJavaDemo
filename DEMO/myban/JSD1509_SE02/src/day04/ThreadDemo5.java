package day04;
/**
 * ��ȡ�߳���Ϣ
 * @author Administrator
 *
 */
public class ThreadDemo5 {
	public static void main(String[] args) {
		Thread t= Thread.currentThread();
		
		long id=t.getId();
		System.out.println("�̱߳�ʶ��ID: "+id);
		
		String name=t.getName();
		System.out.println("�߳�����name: "+name);
		
		//�߳����ȼ�
		int priority=t.getPriority();
		System.out.println("�߳����ȼ�priority: "+priority);
		
		System.out.println("�̵߳�״̬getState: "+t.getState());
		
		System.out.println("�߳��Ƿ���״̬isAlive: "+t.isAlive());
		System.out.println("�߳��Ƿ�Ϊ�ػ��߳�isDaemon: "+t.isDaemon());
		System.out.println("�߳��Ƿ��ж�isInterrupted: "+t.isInterrupted());
		
		
	}
}
