package day04.copy;
/**
 * ʹ�������ڲ������ʽʹ�÷�ʽ1�ͷ�ʽ2����Thread
 * @author Administrator
 *
 */
public class ThreadDemo03 {
	public static void main(String[] args) {
		//��ʽ1��ֱ�Ӽ̳�Thread
		Thread t1 = new Thread(){
			public void run(){
				for(int i = 0; i < 1000; i ++){
					System.out.println("����˭����");
				}
			}
		};
		//��ʽ2��ʵ��Runnable�ӿ�
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				for(int i = 0; i < 1000; i++){
					System.out.println("���ǲ�ˮ���...");
				}
			}
		});
		t1.start();
		t2.start();
		System.out.println("��������ˣ�");//------???�������
	}
}
















