package day04.case04;
/**
 * ����3
 * ����Thread���  Thread  currentThread()����
 * @author Administrator
 *
 */
public class TestCurrentThread {
	public static void main(String[] args) {
		System.out.println("����main�������߳��ǣ�"+ Thread.currentThread());
		testCurrent();
		Thread t = new Thread(){
			public void run(){
				System.out.println("�߳�t:"+ Thread.currentThread());
				testCurrent();
			}
		};
		t.start();
	}
	
	/*
	 * ��ͬ���̵߳��ø÷�������ȡ��ǰ�̵߳����
	 */
	public static void testCurrent(){
		System.out.println("�������е��߳��ǣ�"+ Thread.currentThread());
	}
}
