package a01;

import java.util.Scanner;
//计算个税程序
public class day03_06_incometax {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入你的税前工资的金额数字（￥）：");
		double salay = scan.nextDouble();
		scan.close();
		double taxIncome = salay - 3500;
		double tax = 0;
		if( taxIncome <= 0 ){
			tax = 0;
		}else if( taxIncome <= 1500){
			tax = taxIncome * 0.03;
		}else if( taxIncome <= 4500 ){
			tax = taxIncome * 0.1 - 105; 
		}else if( taxIncome <= 9000 ){
			tax = taxIncome * 0.2 - 555;
		}else if( taxIncome <= 35000 ){
			tax = taxIncome * 0.25 - 1005;
		}else if( taxIncome <= 55000 ){
			tax = taxIncome * 0.30 - 2755;
		}else if( taxIncome <= 80000 ){
			tax = taxIncome * 0.35 - 5505;
		}else if( 80000 < taxIncome ){
			tax = taxIncome * 0.45 -13505;
		}
		System.out.println("你应该缴纳的个人所得税是：（￥）" + tax);
	}	
}
