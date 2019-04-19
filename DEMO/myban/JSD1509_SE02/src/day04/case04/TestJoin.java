package day04.case04;
/**
 * ����7
 * ����join
 * 1.�����߳�1������ͼƬ�������߳�2����ʾͼƬ
 * 2.�����߳�1���߳�2��Ҫ�����߳�2�����У������߳�1���߳�1�����󣬲��ܼ����߳�2.
 * @author Administrator
 *
 */
public class TestJoin {
	public static void main(String[] args) {
		//�߳�1������ͼƬ�߳�
		final Thread download = new Thread(){
			public void run(){
				System.out.println("down��ʼ����ͼƬ....");
				for(int i = 0; i <= 100; i += 2){
					System.out.println("down:"+ i +"%");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(i == 100){
						System.out.println("downͼƬ������ϣ�");
					}
				}
			}
		};
		
		//�߳�2����ʾͼƬ
		Thread show = new Thread(){
			public void run(){
				System.out.println("show : ��ʼ׼����ʾͼƬ...");
				try {
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("show : ͼƬ��ʾ��ϣ�");
			}
		};
		
		//�����߳�1���߳�2
		download.start();
		show.start();
	}
}













