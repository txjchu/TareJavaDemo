package day05;
/**
 * ��Ч����Сͬ����Χ������߲���Ч��
 * ʹ��synchronized������Сͬ����Χ
 * @author Administrator
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				shop.buy();
			}
		};
		t1.start();
		t2.start();
	}
}

class Shop{
	public void buy(){
		try{
			Thread t = Thread.currentThread();
			System.out.println(t+"������ѡ�·�...");
			Thread.sleep(5000);
			/*
			 * ʹ��synchronized�飬��Ҫָ��
			 * ͬ��������(�����Ķ���)
			 * ֻҪ��֤����߳̿�������ͬһ������
			 * ��ô�;���ͬ��Ч��!
			 * ͨ��ʹ��this�Ϳ��ԡ�
			 */
			synchronized(this){
				System.out.println(t+"�������·�...");
				Thread.sleep(5000);
			}
			
			System.out.println(t+"�����뿪");
		}catch(Exception e){
		}
	}
}




