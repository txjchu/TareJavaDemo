package day05;
/**
 * wait��notify��������Object  �϶���ġ�
 * ����Э���߳�ͬ��ʹ�ã����join ������ͬ���ļ�ʱ�Ը�ǿ����Ϊjoin����ȴ�
 * ��һ���߳����й�����������
 * @author Administrator
 *
 */
public class WaitAndNotifyDemo {
	//��ʾͼƬ�Ƿ��������
	public static boolean isFinish;
	
	public static Object obj = new Object();
	
	public static void main(String[] args){
		//�����߳�
		final Thread download = new Thread(){
			public void run(){
				System.out.println("down:��ʼ����......");
				for(int i=0;i<=100;i++){
					System.out.println("down:"+i+"%");
					try{
						Thread.sleep(50);
					}catch(InterruptedException e){
					}
					}
				System.out.println("down:ͼƬ������ϣ�");
				isFinish=true;//----------
				/*
				 * ������Ϳ���֪ͨ��ʾ�߳�����ʾͼƬ�ˡ�
				 */
				synchronized(obj){
				obj.notify();
				}
			}
			};
			//��ʾͼƬ�̣߳�
			Thread show = new Thread(){
				public void run(){
					System.out.println("show:��ʼ��ʾͼƬ...");
					//Ӧ���ȴ������߳̽�ͼƬ�������
					try{
						/*
						 * ��һ�������еľֲ��ڲ�����
						 * ��������������������ֲ������򷽷�������
						 * ��ô������������������final�ġ�
						 */
						
//						download.join();
						
						/*
						 * �÷����ᵼ��show�߳̽�������״̬��ֱ��obj.notify �����òŻ�����
						 */
						obj.wait();
					}catch(InterruptedException e){
					}
				if(!isFinish){
					throw new RuntimeException("ͼƬ�����ڣ�");
				}
				System.out.println("shwo:ͼƬ��ʾ��ɣ�");
				}
				
			};
		download.start();
		show.start();
	}
}

