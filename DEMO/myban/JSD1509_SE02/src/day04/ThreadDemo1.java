package day04;
/**
 * �̣߳�ͨ�����ڽ��ͬʱ���ж������
 * ��ͬʱ���Ǹй��ϵģ�ʵ���϶���߳�֮��������ͣͣ�Ĳ������з�ʽ��
 * 
 * �����߳�
 * 
 * ���ַ�ʽ��
 * ��һ�֣�ֱ�Ӽ̳�Thread�ಢ��дrun�����������߳�Ҫִ�е�������롣
 * 
 * 
 * @author Administrator
 * 
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
//		for(int i=0;i<1000;i++){
//			System.out.println("����˭����");
//			System.out.println("���ǲ�ˮ��ģ�");
//		}
		Thread t1=new MyThread1();
		Thread t2=new MyThread2();
		/*
		 * �����߳�Ҫִ��start������ʹ�䱻���뵽�̵߳����С�
		 * һ���̵߳��Ƚ�CPUʱ��Ƭ�η������ǰ�̣߳���ô��ǰ�̵߳�run�������Զ������ÿ�ʼִ�С�
		 * start ִ�еĹ�����run�������ᱻ���õģ�����ִ����Ϻ�run������ܿ�ı�ִ��������
		 */
		t1.start();//----���ܵ���run������
		t2.start();
		
		
		
		
	}
}

/**
 * ��һ�ִ����̵߳ķ�ʽ���������㣺
 * 1.����java�ǵ��̳У����Ե�ǰ�����̳���Thread ���Ͳ����ټ̳������࣬
 * 	   �����ϵͳ�ܹ���������ܲ����롣
 * 2.�߳��ڲ���дrun�������������������߳���������һ��ǿ��Ϲ�ϵ��
 *   �̻߳��������ԣ����ȷǳ��
 * �ŵ㣺
 * ����򵥣����Գ������������ڲ���Ĵ�����ʽ��  
 * @author Administrator
 *
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
			System.out.println("���ǲ�ˮ��ģ�");
		}
	}
}










