package day03;

import java.util.Scanner;

//作业题3
public class Test3 {
	public static void main(String[] args) {
		
		//练习此案例【】
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个数字:");
		String line = scanner.nextLine();
		
		//判断是否为整数
		if(line.matches("[0-9]+")){
			int i = Integer.parseInt(line);
			System.out.println("这是一个整数:"+i);
		//判断是否为小数
		}else if(line.matches("[0-9]+\\.[0-9]+")){
			double d = Double.parseDouble(line);
			System.out.println("这是一个小数:"+d);
		}else{
			System.out.println("数字格式不正确");
		}
		
		
	}
}
