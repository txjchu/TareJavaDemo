package day04;

import java.util.Scanner;

//��������Ϸ
public class Guessing {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int num=(int)(Math.random()*1000+1);//���������Ǹ���,�������1-1000֮�ڵ����֡�
		//Math.random()*1000+1;Math.random�������һ��0.0-0.99999....֮���һ������
		
		//System.out.println(num);//����
		int guess;
		do{
			System.out.println("�°ɣ�");
			guess=scan.nextInt();   //1.
			if(guess==0){
				System.out.println("�´�������");
				break;
			}else if(guess>num){
				System.out.println("̫����");
				
			}else {
				System.out.println("̫С��");
			}
			System.out.println("�°ɣ�");
			guess=scan.nextInt();     //3.
		}while(guess!=num);   //2.
		if(guess==num){
			System.out.println("��ϲ�㣬�¶��ˣ�");
		}
		
		
		/*
		System.out.println("�°ɣ�");
		int guess=scan.nextInt();   //1.
		while(guess!=num){     //2.
			if(guess==0){
				System.out.println("�´�������");
				break;
			}
			if(guess>num){
				System.out.println("̫����");
				
			}else{
				System.out.println("̫С��");
			}
			System.out.println("�°ɣ�");
			guess=scan.nextInt();     //3.
			}
		if(guess==num){
			System.out.println("��ϲ�����ˣ�");
		}
			*/
			
/*
 * 1.������һ����num
 * 2.ѭ����Ҫ��
 * 3.
 * 
 * 
 * 
 * ��������ֵ��
 * 1��int num=5;
 */
	}

}
