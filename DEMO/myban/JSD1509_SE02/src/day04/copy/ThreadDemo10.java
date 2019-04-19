package day04.copy;
/**
 * void join()
 * �÷������������õ�ǰ�������̣߳�����join�����Ķ����߳��ϵȴ���ֱ�����߳���ɹ�������ǰ�̲߳Ż���������������ִ�С�
 * ���磺
 * a�̵߳�����b�̵߳ķ�����b.join()
 * ��ôa�߳� �ͽ���������״̬��ֱ��b�߳�ִ����ϣ�a�ֳ��ƲŻ���join����������ִ�С�
 * 
 * join������Ϊ�˽���̼߳�ͬ�������ġ�
 * @author Administrator
 *
 */
public class ThreadDemo10 {
	//��ʾͼƬ�Ƿ��������
	public static boolean isFinish;
	
	public static void main(String[] args) {
		//�����߳�
		final Thread download = new Thread(){
			public void run(){
				System.out.println("down:��ʼ����ͼƬ...");
				for(int i = 0; i <= 100; i ++){
					System.out.println("down : "+ i +"%");
					try {
						Thread.sleep(50);//����50����
					} catch (Exception e) {
					}
				}
				System.out.println("down : ͼƬ�������!");
				isFinish = true;
			}
		};
		
		//��ʾͼƬ�߳�
		Thread show = new Thread(){
			public void run(){
				System.out.println("show : ��ʼ��ʾͼƬ...");
				//Ӧ���ȴ�����ͼƬ�߳̽�ͼƬ�������
				/*
				 * ��һ�������еľֲ��ڲ�����������������������ֲ������򷽷���������ô������������������final�ġ�
				 */
				try {
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(!isFinish){
					throw new RuntimeException("ͼƬ�����ڣ�");
				}
				System.out.println("show : ��ʾͼƬ���!");
			}
		};
		
		download.start();
		show.start();
	}
}











