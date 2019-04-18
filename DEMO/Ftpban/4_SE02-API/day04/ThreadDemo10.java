package day04;
/**
 * void join()
 * �÷������������õ�ǰ�������̣߳�����join����
 * �����߳��ϵȴ���ֱ�����߳���ɹ�������ǰ�߳�
 * �Ż���������������ִ��
 * 
 * ����:
 * a�̵߳�����b�̵߳ķ���:b.join()
 * ��ôa�߳̾ͽ���������״̬��ֱ��b�߳�
 * ִ����ϣ�a�̲߳Ż���join����������ִ��
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
				System.out.println(
					"down:��ʼ����ͼƬ...");
				for(int i=1;i<=100;i++){
					System.out.println(
						"down:"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println(
					"down:����ͼƬ���!");
				isFinish = true;
			}
		};
		//��ʾͼƬ�߳�
		Thread show = new Thread(){
			public void run(){
				System.out.println(
					"show:��ʼ��ʾͼƬ...");
				//Ӧ���ȴ������߳̽�ͼƬ�������
				try {
					/*
					 * ��һ�������еľֲ��ڲ�����
					 * ��������������������ֲ������򷽷�������
					 * ��ô������������������final�ġ�
					 */
					download.join();
				} catch (InterruptedException e) {
				}
				
				if(!isFinish){
					throw new RuntimeException("ͼƬ������!");
				}
				System.out.println(
					"show:��ʾͼƬ���!");
			}
		};
		
		
		download.start();
		show.start();
	}
}







