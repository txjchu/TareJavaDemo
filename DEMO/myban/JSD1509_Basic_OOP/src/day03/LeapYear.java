package day03;

import java.util.Scanner;

//������ж�
public class LeapYear {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("��������ݣ�");
		int year=scan.nextInt();
		
		//*��Ŀ����
		boolean flag = (year%4==0 && year%100!=0)||year%400==0;
		String msg = flag? year+"������" : year+"��������";
		System.out.println(msg);
		
		
	}
}