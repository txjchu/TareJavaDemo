package a01;

import java.util.Scanner;

//Switch�������������
public class day03_c05_CommandBySwitch {
	public static void main(String[] args) {
		System.out.println("��ѡ���ܣ�1.��ʾȫ����¼  2.��ѯ��¼��¼  0.�˳�");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		switch(a){
		case 1:
			System.out.println("ȫ����¼��");
			break;
		case 2:
			System.out.println("��¼��¼��");
			break;
		case 0:
			System.out.println("��ӭʹ�ã�");
			break;
		default:
			System.out.println("��������");
		}
	}

}
