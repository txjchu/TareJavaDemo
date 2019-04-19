package day04;
/**
 * void join()
 * �÷������������õ�ǰ�������̣߳�����join���������߳��ϵȴ���ֱ�����߳���ɹ�����
 * ��ǰ�̲߳Ż�Ӵ�������������ִ�С�
 * 
 * ���磺
 * a�̵߳�����b�̵߳ķ�����b.join()
 * ��ôa�߳̾ͽ���������״̬��ֱ��b�߳�ִ����ϣ�a�̲߳Ż�Ӵ�join����������ִ�С�
 * 
 * join������Ϊ�˽���̼߳�ͬ�������ġ�
 * 
 * @author Administrator
 *
 */
public class ThreadDemo10 {
	//��ʾͼƬ�Ƿ��������
	public static boolean isFinish;	
	
	public static void main(String[] args) {
		//�����߳�
		final Thread download= new Thread(){		//Ҫ��download����final
			public void run(){
				System.out.println("down:��ʼ����ͼƬ...");
				for(int i = 0; i <= 100; i ++){
					System.out.println("down : ����"+ i + "%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("down : ͼƬ������ϣ�");
				isFinish = true;//��ͼƬ���״̬��Ϊtrue
			}
		};
		
		//��ʾͼƬ�߳�
		Thread show = new Thread(){
			public void run(){
				System.out.println("show : ��ʼ��ʾͼƬ...");
				try {
					/**
					 * ����һ�������еľֲ��ڲ����У���������������������ֲ������򷽷���������ô����������߷�������
					 * ������final���εġ�
					 */
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(!isFinish){
					throw new RuntimeException("ͼƬ�����ڣ�");
				}
				System.out.println("show : ͼƬ��ʾ��ϣ�");
			}
		};
		
		download.start();
		show.start();
		
		
	}
}












