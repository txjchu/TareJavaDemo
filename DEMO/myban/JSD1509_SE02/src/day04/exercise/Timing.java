package day04.exercise;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 课后习题5	电子表
 * 输出时间	
 * @author Administrator
 *
 */
public class Timing {
	public static void main(String[] args) {
		Thread d = new Thread(){
			public void run(){
				while(true){//不断输出
					Date date = new Date();//时间对象
					SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");//日期格式对象
					System.out.println("时间："+ sdf.format(date));//输出格式化后的日期
					try {
						Thread.sleep(1000);//进入阻塞
					} catch (InterruptedException e) {
						e.printStackTrace();
					}					
				}
			}
		};
		d.setDaemon(true);//设置为守护线程
		d.start();//启动线程
		try {
			Thread.sleep(5000);//当前线程进入阻塞
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//模拟所有前台线程结束，用以观察后天线程的状态
		System.out.println("main方法的线程结束了");
	}
}
