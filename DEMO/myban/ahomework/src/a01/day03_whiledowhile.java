package a01;

import java.util.Scanner;
//while �� do...while �Ƚ�
public class day03_whiledowhile {
	public static void main(String[] args) {
		// while���
//		Scanner scan = new Scanner(System.in);
//		int pwd = 0;
//		while(123 != pwd){
//			System.out.println("���������룺");
//			pwd = scan.nextInt();
//		}
//		System.out.println("��ӭ���룡");
		
		//do...while���
		Scanner scan = new Scanner(System.in);
		int pwd ;
		do{
			System.out.println("���������룺");
			pwd = scan.nextInt();
		}while(123 != pwd);
		System.out.println("������ȷ����ӭ����");
		
		/**
		 * while��do-while��������
			while��do-while��������ִ��ѭ���ṹ����䣬�������ڣ�whileѭ�����ж���ִ�У�
			��do-whileѭ����ִ��һ�Σ����жϡ���ô������ʼ���������ѭ������ʱ��
			whileѭ����һ�ζ�����ִ�У���do-whileѭ�������κ���������ٻ�ִ��һ�Ρ�
			ע�⣺while��do-while���Ĳ�ͬ���������ڵ�һ�ξͲ�����������ѭ���У�
			������������������while��do-while���Ի�����
			
			��˴�pwd��ʼ��Ϊ�ؼ��㡣��while�����pwd��ʼ��Ϊ123ʱ��boolean���ʽΪfalse,
			��ֱ���������ӭ���롱������������while����еĳ���
		 */
	}

}
