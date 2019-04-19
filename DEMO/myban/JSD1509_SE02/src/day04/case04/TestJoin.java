package day04.case04;
/**
 * 案例7
 * 测试join
 * 1.设置线程1，下载图片，设置线程2，显示图片
 * 2.启动线程1，线程2，要求：在线程2进行中，运行线程1，线程1结束后，才能继续线程2.
 * @author Administrator
 *
 */
public class TestJoin {
	public static void main(String[] args) {
		//线程1：下载图片线程
		final Thread download = new Thread(){
			public void run(){
				System.out.println("down开始下载图片....");
				for(int i = 0; i <= 100; i += 2){
					System.out.println("down:"+ i +"%");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(i == 100){
						System.out.println("down图片下载完毕！");
					}
				}
			}
		};
		
		//线程2：显示图片
		Thread show = new Thread(){
			public void run(){
				System.out.println("show : 开始准备显示图片...");
				try {
					download.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("show : 图片显示完毕！");
			}
		};
		
		//启动线程1，线程2
		download.start();
		show.start();
	}
}













