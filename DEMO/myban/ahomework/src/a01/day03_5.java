package a01;

import java.util.Scanner;
//�ж�����

public class day03_5 {
	public static void main(String[] args) {
//		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("��������ݣ��磺2016����");
//		int year = scan.nextInt();
//		scan.close();
//		/**
//		 * �ж�������Ҫ����2�������е�����1����
//		 * 1.�ܱ�4�����Ҳ��ܱ�100����
//		 * 2.�ܱ�400����
//		 */
//		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
//			//1���߼��ж��ǽ����ڹ�ϵ�ж�֮�ϵġ�
//			//2��||(��)��&&(��)���ж�·���󣬵���һ�������Ϳ����жϳ������߼��жϱ��ʽ�Ľ��ʱ��������������ٽ������㡣
//			System.out.println(year+"�������ꡣ");
//		}else{
//			System.out.println(year+"�겻�����ꡣ");
//		}
//		
		Scanner scan = new Scanner(System.in);
		System.out.println("��������ݣ�");
		int year = scan.nextInt();
		scan.close();
		String msg = year %400 == 0 || (year % 4 == 0 && year % 100 != 0) ? year +"������" : year +"��������";
		System.out.println(msg);
	}
}	
