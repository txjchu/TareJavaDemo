package day04;
/**
 * 守护线程
 * 又名后台线程，默认创建出来的线程都是前台线程，后天线程是通过方法指定，使前台线程变为后台线程。
 * 
 * 后天线程与前台线程的区别主要体现在结束时机：
 * 当一个进程中的所有前台线程全部结束时，进程结束，无论进程汇总的后台线程是否还在运行，
 * 都要强制中断。
 * @author Administrator
 *
 */
public class ThreadDemo9 {
	public static void main(String[] args) {
		/*
		 * rose的扮演着：前台线程
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
			System.out.println("rose:啊啊啊啊啊啊AAAAAAAAAAAaaaaaaa");
			System.out.println("效果：噗通！");
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
		
		//设置为后台线程，要在start方法之前调用
		jack.setDaemon(true);
		
		rose.start();
		jack.start();
		
	}
		
		
}

