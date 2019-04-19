package day02.homeWork;

import java.util.Scanner;

import org.junit.Test;

/** 练习03 */
public class TestChange {
	
	
	@Test
	//测试字符串转换为数字或小数的方法
	public void testStringTOIntOrDouble(){
		String intRegex = "^[0-9]+$";//整数的正则表达式
		String decimalRegex = "^[0-9]+\\.[0-9]+$";//小数的正则表达式
		
		Scanner scan = new Scanner(System.in);//创建扫描器对象，接收用户输入
		System.out.println("请输入一个数字：");
		String numberStr = scan.nextLine();//将用户输入的信息保存为String类型数据
		//对用户输入的数据进行判断
		if(numberStr.matches(intRegex)){//若匹配整数
			System.out.println("这是一个数字："+ Integer.parseInt(numberStr));
		}else if(numberStr.matches(decimalRegex)){//若匹配小数
			System.out.println("这是一个小数："+ Double.parseDouble(numberStr));
		}else{
			System.out.println("输入的数字格式不正确！");
		}
	}
}









