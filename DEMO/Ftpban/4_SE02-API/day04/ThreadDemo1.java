package day04;
/**
 * �߳�:ͨ�����ڽ��ͬʱ���ж������
 * "ͬʱ"�Ǹй��ϣ�ʵ���϶���߳�֮��������ͣͣ��
 * �������з�ʽ��
 * 
 * �����߳������ַ�ʽ:
 * ��һ�֣�ֱ�Ӽ̳�Thread�ಢ��дrun������
 * �����߳�Ҫִ�е��������
 * @author Administrator
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread2();
		/*
		 * �����߳�Ҫִ��start������ʹ�䱻���뵽
		 * �̵߳����С�һ���̵߳��Ƚ�CPUʱ��Ƭ��
		 * �������ǰ�̣߳���ô��ǰ�̵߳�run����
		 * ���Զ������ÿ�ʼִ�С�
		 * startִ�еĹ�����run�����ǲ��ᱻ���õģ�
		 * ����ִ����Ϻ�run������ܿ�ı�ִ��������
		 */
		t1.start();
		t2.start();
	}
}
/**
 * ��һ�ִ����̵߳ķ�ʽ���������㣺
 * 1:����java�ǵ��̳У����Ե�ǰ�����̳���Thread��
 *   ��Ͳ����ټ̳������࣬�����ϵͳ�ܹ����������
 *   �����롣
 * 2:�߳��ڲ���дrun�������������������߳�������
 *   ��һ��ǿ��Ϲ�ϵ���̻߳��������ԣ����ȷǳ�
 *   ��  
 * �ŵ�:
 * ����򵥣����Գ������������ڲ���Ĵ�����ʽ��
 */
class MyThread1 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("����˭����");
		}
	}
}
class MyThread2 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("���ǲ�ˮ����!");
		}
	}
}





