package day04;
/**
 * �ػ��߳�
 * ������̨�̣߳�Ĭ�ϴ����������̶߳���ǰ̨�̣߳������߳���ͨ������ָ����ʹǰ̨�̱߳�Ϊ��̨�̡߳�
 * 
 * �����߳���ǰ̨�̵߳�������Ҫ�����ڽ���ʱ����
 * ��һ�������е�����ǰ̨�߳�ȫ������ʱ�����̽��������۽��̻��ܵĺ�̨�߳��Ƿ������У�
 * ��Ҫǿ���жϡ�
 * @author Administrator
 *
 */
public class ThreadDemo9 {
	public static void main(String[] args) {
		/*
		 * rose�İ����ţ�ǰ̨�߳�
		 */
		Thread rose= new Thread(){
			public void run(){
				for(int i=0;i<10;i++){
					System.out.println("rose:let me go!");
					
					try{
						Thread.sleep(1000);
					}catch(InterruptedException e){
					}
				}
			System.out.println("rose:������������AAAAAAAAAAAaaaaaaa");
			System.out.println("Ч������ͨ��");
			}
		};
		
		Thread jack = new Thread(){
			public void run(){
				while(true){
					System.out.println("jack:you jump!i jump!");
					try{
						Thread.sleep(1000);
					}catch(InterruptedException e){
				}		}	
			}
		};
		
		//����Ϊ��̨�̣߳�Ҫ��start����֮ǰ����
		jack.setDaemon(true);
		
		rose.start();
		jack.start();
		
	}
		
		
}

