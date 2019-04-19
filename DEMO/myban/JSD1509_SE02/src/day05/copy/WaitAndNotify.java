package day05.copy;
/**
 * wait��notify��������Object�϶���ġ�����Э���߳�ͬ��ʹ�ã����join������
 * ͬ���ļ�ʱ�Ը�ǿ����Ϊjoin����ȴ���һ���߳����й���������
 */
public class WaitAndNotify {
	//��ʾͼƬ�Ƿ��������
	public static boolean isFinish;
	
	public static Object obj = new Object();
	
	public static void main(String[] args) {
		//�����߳�
		final Thread downLoad = new Thread(){
			public void run(){
				System.out.println("down :��ʼ����ͼƬ...");
				for(int i = 0; i <= 100; i ++){
					System.out.println("down : ͼƬ "+ i +"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("down : ����ͼƬ��ϣ�");
				isFinish = true;
				/*
				 * ������Ϳ���֪ͨ��ʾ�߳�����ʾͼƬ��
				 */
				synchronized(obj){
					obj.notify();//֪ͨ�������������߳�
				}
				
				System.out.println("down : ��ʼ���ظ���...");
				for(int i = 0; i <= 100; i++){
					System.out.println("down : ����"+ i +"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("down : ����������ϣ�");
			}
		};
		
		//��ʾͼƬ�߳�
		Thread show = new Thread(){
			public void run(){
				System.out.println("show : ��ʼ��ʾͼƬ...");
				//Ӧ���ȴ�����С�سǽ�ͼƬ������ϣ������߳�join����
				try {
					/*
					 * ��һ�������еľֲ��ڲ����У���������������������ֲ������򷽷���������ô������������������final�ġ�
					 */
					
//					downLoad.join();
					synchronized(obj){
						obj.wait();
					}
				} catch (InterruptedException e) {
				}
				if(!isFinish){
					throw new RuntimeException("ͼƬ�����ڣ�");
				}
				System.out.println("show : ��ʾͼƬ��ϣ�");
			}			
		};
		downLoad.start();
		show.start();
		System.out.println(downLoad.getState().toString());
		System.out.println(show.getState().toString());
	}
}














