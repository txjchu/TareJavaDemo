package a01;

import java.util.Scanner;

/**
 * Fibonacci쳲��������� -- �������������⡿
 * 1.1��1��2��3��5��8��13��21...��������ô���ģ���
 * 2.�㷨����������ǰ����֮�ͣ���һ�£��ڶ��¶���1
 * 3.
 * 3.month���ܹ��󣬳���42+�򳬹�Int��Χ
 * @author Administrator
 *
 */
public class day06_Fibonacci {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������Ҫ��ѯ�ڼ��£�");
		int month = scan.nextInt();
		int n = rBirth(month);
		System.out.println("��"+ month +"��������"+ n +"��");
		//ѭ�����
		int f1 = 1, f2 = 1, f ; 
		for(int i = 3; i <= month; i++){
			f = f2;
			f2 = f1 + f2;
			f1 = f;
		}
		if(month == 0){
			f2 = 0;
		}
		System.out.println("��"+ f2 +"������");
	}
	
	//�ݹ鷨  + ��֧���
	public static int rBirth(int month){
		if(month == 0){
			return 0;
		}else if(month == 1){
			return 1;
		}else{
			return rBirth(month - 1)+ rBirth(month -2);
		}
	}
}
