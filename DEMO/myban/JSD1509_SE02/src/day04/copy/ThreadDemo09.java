package day04.copy;
/**
 * �ػ��߳�	������̨�߳�
 * Ĭ�ϴ����������̶߳���ǰ̨�̡߳���̨�߳���ͨ������ָ����ʹǰ̨�̱߳�Ϊ��̨����
 * ��̨�߳���ǰ̨�̵߳�������Ҫ�����Ž���ʱ����
 * ��һ�������е�����ǰ̨�߳�ȫ������ʱ�����̽��������۽����еĺ�̨�߳��Ƿ������У���Ҫ��ǿ����ֹ�� 
 * @author Administrator
 *
 */
public class ThreadDemo09 {
	public static void main(String[] args) {
		/*
		 * rose�İ����ţ�ǰ̨�߳�
		 */
		Thread rose = new Thread(){
			public void run(){
				for(int i = 0; i < 10; i ++){
					System.out.println("rose : let me go !");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("rose : ����������AAAAAAaaaa...");
				System.out.println("Ч�� �� ��ͨ��~~");
			}
		};
		
		/*
		 * jack�����ߣ���̨����
		 */
		Thread jack = new Thread(){
			public void run(){
				while(true){
					System.out.println("jack : you jump ! i jump !");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
		};
		//����jackΪ��̨�̣߳�Ҫ��start��������ǰ����
		jack.setDaemon(true);
		rose.start();
		jack.start();
		//��������ǰ̨�߳̽���ǰ��2���߳�һֱ�������У���ǰ���߳�һ��������̨�߳���������ֹ��
	}
}















