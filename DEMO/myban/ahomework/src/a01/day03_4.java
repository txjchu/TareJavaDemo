package a01;

import java.util.Scanner;
//�Ƚ��û������3�����֣�������С����
public class day03_4 {
	public static void main(String[] args) {
//		//�Ƚ��û������3�����ֵĴ�С
//		Scanner scan = new Scanner(System.in);
//		System.out.println("������3�����֣������м��ÿո��������");
//		int a1 = scan.nextInt();
//		int a2 = scan.nextInt();
//		int a3 = scan.nextInt();
//		System.out.println("����������������ǣ�a="+a1+"��b="+a2+"��c="+a3);
//		int b1 = a1 > a2 ? a1 : a2;
//		int b2 = b1 > a3 ? b1 : a3;
//		System.out.println("�������������ֵΪ��"+b2);
		
		//�Ƚ��û������3�����ֲ���������
		Scanner scan = new Scanner(System.in);
		System.out.println("������3�����֣������ÿո��������");
		int a1 = scan.nextInt();
		int a2 = scan.nextInt();
		int a3 = scan.nextInt();
		scan.close();
		System.out.println("����������������ǣ�a="+a1+",b="+a2+"��c="+a3);
//		int b1 = a1 > a2 ? a1 : a2;
//		int b2 = b1 > a3 ? b1 : a3;
//		System.out.println(b1);----���������һ��Ҫ��ʼ������Ȼ�쳣
		if(a1 < a2){
			int b1 = 0;			
			b1 = a2 ;
			a2 = a1 ;
			a1 = b1 ;
		}
		if(a1 < a3){
			int b2 = 0;
			b2 = a3;
			a3 = a1;
			a1 = b2;
		}
		if(a2 < a3){
			int b3 = 0;
			b3 = a3;
			a3 = a2;
			a2 = b3;
		}
		System.out.println("�������ְ��մ�С�����˳���ǣ�a="+a3+",b="+a2+",c="+a1);
			
		
	}
}
