package day04;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ӱ�
 * ÿ�������һ�ε�ǰϵͳʱ��
 * ��ʽ��HH��mm:ss
 * @author Administrator
 *
 */
public class ThreadDemo8 {
	public static void main(String[] args) {
		SimpleDateFormat sdf
			= new SimpleDateFormat("HH-mm-ss");
		
		while(true){
			Date now = new Date();
			System.out.println(sdf.format(now));
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				
			}
		}
		
		
		
	}
}
