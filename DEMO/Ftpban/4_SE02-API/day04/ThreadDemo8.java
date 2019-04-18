package day04;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 电子表
 * 每秒钟输出一次当前系统时间
 * 格式:HH:mm:ss
 * @author Administrator
 *
 */
public class ThreadDemo8 {
	public static void main(String[] args) {
		SimpleDateFormat sdf
			= new SimpleDateFormat("HH:mm:ss");
		
		while(true){
			Date now = new Date();
			System.out.println(sdf.format(now));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}



