package exam;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * WEEK03_EXAM	第三周考试题
 * @author Administrator
 *
 */
public class Week03Exam {
	
	public static void testStr(String str){
		int chack = 3;
		if(chack == str.length()){
			System.out.print(str.charAt(chack - 1) +",");
		}else{
			System.out.print(str.charAt(0) +",");
		}
	}
	@Test
	public void test01(){//第一题
		testStr("four");
		testStr("tea");
		testStr("to");
	}
	@Test
	public void test02(){
		String str = "NASDAQ欢迎你";
		String newStr = str.substring(4, 7);
		System.out.println(newStr);
	}
	@Test
	public void test03(){
		String str = "tarena7cstp8info9";
		String[] strs = str.split("\\d");
		System.out.println(Arrays.toString(strs));//[tarena, cstp, info]
	}
	@Test
	public void test06(){
		Double i = 12.3;
		double j = 12.3;
		System.out.println("It is "+ (i == j) +" that i == j.");
	}
	@Test
	public void test07(){
		Date date = new Date();
		long time = date.getTime();
		date.setTime(time + 24 * 60 * 60 * 1000);
		System.out.println(date.toString());
	}
	@Test
	public void test08(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		System.out.println(str);//2017-07-05
	}
	@Test
	public void test09(){
		Calendar cal = Calendar.getInstance();//创建Calendar抽象类的对象。
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
		cal.set(Calendar.YEAR, 2013);//设置年
		cal.set(Calendar.MONTH, Calendar.JANUARY);//设置月分量
		cal.set(Calendar.DATE, 1);
		for(int i = 0; i < 12; i ++){
			System.out.println(sdf.format(cal.getTime()) +"有"+ cal.getActualMaximum(Calendar.DATE) +"天！");
			cal.add(Calendar.MONTH, 1);
		}		
	}
	@Test
	public void test10(){
		try {
			File dir = new File("d");
			File f = new File(dir, "f");
			if(!f.exists()){
					f.createNewFile();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}












