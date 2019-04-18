package day05;

/**
 * wait��notify��������Object �϶���ġ�
 * ����Э���߳�ͬ��ʹ�ã����join ������
 * ͬ���ļ�ʱ�Ը�ǿ����Ϊjoin����ȴ�
 * ��һ���߳����й�����������
 * 
 * @author Administrator
 * 
 */
public class WaitAndNotifyDemo {
	// ��ʾͼƬ�Ƿ��������
	public static boolean isFinish;
	
	public static Object obj = new Object();

	public static void main(String[] args) {
		// �����߳�
		final Thread download = new Thread() {
			public void run() {
				System.out.println("down:��ʼ����ͼƬ...");
				for (int i = 1; i <= 100; i++) {
					System.out.println("down:" + i + "%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("down:����ͼƬ���!");
				isFinish = true;
				/*
				 * ������Ϳ���֪ͨ��ʾ�߳�����ʾͼƬ��
				 */
				synchronized (obj) {
					obj.notify();
				}
				
				
				System.out.println("down:��ʼ���ظ���...");
				for (int i = 1; i <= 100; i++) {
					System.out.println("down:" + i + "%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
					}
				}
				System.out.println("down:�����������!");
			}
		};
		// ��ʾͼƬ�߳�
		Thread show = new Thread() {
			public void run() {
				System.out.println("show:��ʼ��ʾͼƬ...");
				// Ӧ���ȴ������߳̽�ͼƬ�������
				try {
					/*
					 * ��һ�������еľֲ��ڲ����� ��������������������ֲ������򷽷������� ��ô������������������final�ġ�
					 */
//					download.join();
					/*
					 * �÷����ᵼ��show�߳̽�������״̬��
					 * ֱ��obj.notify�����òŻ�����
					 */
					synchronized (obj) {
						obj.wait();
					}		
				} catch (InterruptedException e) {
				}

				if (!isFinish) {
					throw new RuntimeException("ͼƬ������!");
				}
				System.out.println("show:��ʾͼƬ���!");
			}
		};

		download.start();
		show.start();
	}

}
