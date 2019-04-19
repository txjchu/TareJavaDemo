package day04.copy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 电子表
 * 每秒钟输出一次当前系统时间，格式HH:mm:ss
 * @author Administrator
 *
 */
public class ThreadDemo08 {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		while(true){
			Date now = new Date();
			System.out.println(sdf.format(now));
			try {
				/*
				 * 此处用Thread线程的阻塞方法sleep，阻塞的是调用main方法的mian线程，运行1次就阻塞1秒。
				 */
				Thread.sleep(1000);//间隔一秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}















