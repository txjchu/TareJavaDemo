package day05;
/**
 * synchronized�Ļ�����Ч����
 * ��ʹ��synchronized�����˴������κ�ֻҪ��������ͬ�������δ���;����˻���Ч����
 * @author Administrator
 *
 */
public class SyncDemo4 {
	public static void main(String[] args) {
	final Foo foo= new Foo();
	Thread t1 = new Thread(){
		public void run(){
			foo.methodA();
	}
	};	
		Thread t2 = new Thread(){
			public void run(){
				foo.methodB();
			}
		};
		t1.start();
		t2.start();
	}
}

class Foo{
	public synchronized void methodA(){
		Thread t = Thread.currentThread();
		System.out.println(t+"���ڵ���a����......");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
		}
		System.out.println(t+"����a������ϣ�");
	}
	public synchronized void methodB(){
		Thread t=Thread.currentThread();
		System.out.println(t+"���ڵ���b����......");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println(t+"����b������ϣ�");
	}
}