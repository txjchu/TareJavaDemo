package day02.copy;

import java.util.Scanner;

/**
 * ������������- -!
 * @author Administrator
 *
 */
public class ������ {
	static String num1;
	static String num2;
	static Scanner getNumber;//��ȡ�û�����
	static boolean flagtoopen = false;
	public static void main(String[] args) {
		int a = 25702;
		Integer b = Integer.valueOf(25702);
		System.out.println(b == a);//true	???
		
		
//		������ ������ = new ������();
		getNumber = new Scanner(System.in);//�����û�����
		System.out.println("�ף���ӭ��������������һ�������ǣ�");
		num1 = getNumber.next();
		if(num1.matches("\\d+")){
			System.out.println("�ڶ������ǣ�");
		}else{
			System.out.println("�������������������");
		}
		num2 = getNumber.next();
		if(num2.matches("\\d+")){//�ж�
			System.out.println("�����"+ (Integer.parseInt(num1) + Integer.parseInt(num2)));
			
		}else{
			System.out.println("�������������������");
		}
	}
}
