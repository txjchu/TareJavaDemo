package day04;

import java.util.Scanner;
//������	�յ�Ϊ��ǰ���úã�
public class Guessing01 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int num=250;
		System.out.println("��°ɣ�");
		int guess;//������doǰ����Ϊwhile�ж���������Ҫ�õ�guess��
		do{
			guess = scan.nextInt();
			if(guess == 0){
				System.out.println("���ź����´�������");
			}else if(guess > num){
				System.out.println("̫���ˣ�");
			}else if(guess < num){
				System.out.println("̫С�ˣ�");
			}
		}while(guess != num);
		System.out.println("��ϲ�����ˣ�");
		scan.close();
	}
}
