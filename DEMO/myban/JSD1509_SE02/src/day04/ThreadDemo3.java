package day04;
/**
 * �������ڲ������ʽʹ�÷�ʽ1�ͷ�ʽ2����Thread
 * @author Administrator
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		//����1��ֱ�Ӽ̳�Thread
		Thread t1=new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("����˭����");
				}
			}
		};
		
		//����2������Runnable
		Runnable runn = new Runnable(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("���ǲ�ˮ��ģ�");
				}
			}
		};
		
		
		Thread t2=new Thread(runn);
		
		t1.start();
		t2.start();
		
		System.out.println("����������𣿣�������������");
	}
}
