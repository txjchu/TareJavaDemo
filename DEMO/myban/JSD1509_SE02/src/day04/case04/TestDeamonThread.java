package day04.case04;
/**
 * ����5
 * �����ػ��̣߳���̨�̣߳�
 * @author Administrator
 *
 */
public class TestDeamonThread {
	public static void main(String[] args) {
		//����һ����̨�߳�
		Thread deamon = new Thread(){
			public void run(){
				while(true){
					System.out.println("��̨�߳�");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}					
				}
			}
		};
		deamon.setDaemon(true);//����Ϊ��̨�߳�
		deamon.start();
		
		//main�߳�
		Thread t1 = Thread.currentThread();
		try {
			t1.sleep(5000);//��ǰ�߳�main�߳̽�������
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//���������е�ǰ���߳̽��������еĺ�̨�̶߳������
		System.out.println("main�߳̽�����!");
	}
}
