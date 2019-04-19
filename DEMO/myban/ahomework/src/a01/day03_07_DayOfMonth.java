package a01;

import java.util.Scanner;

//计算用户输入的某年某月有多少天

public class day03_07_DayOfMonth {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入年份（例如2016）：");
		int year = scan.nextInt();
		System.out.println("请输入月份（例如12）：");
		int month = scan.nextInt();
		int dayOfMonth = 0;
		scan.close();	//不要忘记关闭scan对象
		
		switch(month){
			case 2:
				//计算是否为闰年，是则2月为29天，否则为28天
				if(year % 400 == 0 ||(year % 4 == 0 && year % 100 != 0)){
					dayOfMonth = 29;
				}else{
					dayOfMonth = 28;
				}
				break;	
			case 4:
			case 6:
			case 9:
			case 11:
				dayOfMonth = 30;
				break;
			default:
				dayOfMonth = 31;
				break;
		}
		System.out.println(year +"年"+ month +"月有"+ dayOfMonth +"天");	
		
//		switch(month){
//			case 1 :
//				dayOfMonth = 31;
//				break;
//			case 5:
//				dayOfMonth = 31;
//				break;
//			case 7:
//				dayOfMonth = 31;
//				break;
//			case 8:
//				dayOfMonth = 31;
//				break;
//			case 10:
//				dayOfMonth = 31;
//				break;
//			case 12:
//				dayOfMonth = 31;
//				break;
//			case 3:
//				dayOfMonth = 31;
//				break;	
//			case 4:
//				dayOfMonth = 30;
//				break;
//			case 6:
//				dayOfMonth = 30;
//				break;
//			case 9:
//				dayOfMonth = 30;
//				break;
//			case 11:
//				dayOfMonth = 30;
//				break;
//			case 2:
//				if(year % 400 == 0 || (year % 4 == 0 && year %100 != 0)){
//					dayOfMonth = 29;
//				}else{
//					dayOfMonth = 28;					
//				}
//				break;
//		}
//		System.out.println(year +"年"+ month +"月有"+ dayOfMonth +"天");
	}
}

