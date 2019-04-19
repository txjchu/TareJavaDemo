package day04.copy;
/**
 * 守护线程	又名后台线程
 * 默认创建出来的线程都是前台线程。后台线程是通过方法指定，使前台线程变为后台程序。
 * 后台线程与前台线程的区别主要体现着结束时机：
 * 当一个进程中的所有前台线程全部结束时，进程结束，无论进程中的后台线程是否在运行，都要被强制终止。 
 * @author Administrator
 *
 */
public class ThreadDemo09 {
	public static void main(String[] args) {
		/*
		 * rose的扮演着：前台线程
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
				System.out.println("rose : 啊啊啊啊啊AAAAAAaaaa...");
				System.out.println("效果 ： 噗通！~~");
			}
		};
		
		/*
		 * jack扮演者：后台进程
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
		//设置jack为后台线程，要在start方法调用前设置
		jack.setDaemon(true);
		rose.start();
		jack.start();
		//输出结果，前台线程结束前，2个线程一直并发运行，当前提线程一结束，后台线程立即被终止。
	}
}















