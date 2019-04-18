package day03;

import java.util.Date;


/**
 * java.util.Date
 * Date的每一个实例都表示一个具体的时间点。
 * 内部维护一个long值，该值表示的是从UTC时间1970年
 * 元旦到描述的时间点所经过的毫秒差
 * 由于Date存在设计缺陷，所以大部分操作时间的方法都
 * 已过时，现在仅适用它表示一个时间点即可，不用于操作
 * 时间。
 * @author Administrator
 *
 */
public class DateDemo1 {
	public static void main(String[] args) {
		/*
		 * 默认创建出来的Date表示当前系统时间
		 */
		Date date = new Date();
		/*
		 * Date重写的toString对于非英语
		 * 地区而言不是很友好。
		 */
		System.out.println(date);
		
		
		//获取其内部维护的long值
		long time = date.getTime();
		
		System.out.println(time);
		
		//计算明天这一刻的时间
		time += 1000*60*60*24;
		
		//使Date表示给定毫秒值所表示的时间
		date.setTime(time);
		
		System.out.println(date);
		
	}
}







