package a01;

import java.util.Scanner;

//������û������3�������е����ֵ
public class day03_08_MaxOfThree {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������3������a,b,c���Կո��������");
		//�����û������3������
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		scan.close();
		
		int result = (a > b ? a : b) > c ? (a > b ? a : b) : c;
		System.out.println("���ֵΪ"+ result);
		
//		int d = a > b ? a : b;
//		int e = d > c ? d : c;
//		System.out.println("�����Ϊ"+ e);
	}

}
