package a01;

import java.util.Scanner;

//������
public class day04_guess {
	public static void main(String[] args) {
//=============V2.0,do...while
		int num = (int) (Math.random()* 1000)+ 1;
		
//		System.out.println("��������µ����֣�1-1000��������0�˳���");=======����do�����
		Scanner scan = new Scanner(System.in);
		int guess = -1;//====���ó�ʼֵ
		do{
			System.out.println("��������µ����֣�1-1000��������0�˳���");
			guess = scan.nextInt();
			if(guess == 0){
//				System.out.println("���ź����´�������");
				break;
			}else if(guess < num){
				System.out.println("̫С�ˣ�");				
			}else if(guess > num){
				System.out.println("̫���ˣ�");				
			}
		}while(guess != num);
		scan.close();
		if(guess == num){
			System.out.println("��ϲ�����ˣ�");
		}else{
			System.out.println("���ź���");
		}

//=============V1.0,while		
////		int num = 5;//�ȴ���һ�������յ�
//		int num = (int) (Math.random()* 1000)+ 1;//0.0-0.9999...?+1
//		
//		int guess ;
//		System.out.println("��������µ����֣�1-1000�����˳�������0:");
//		Scanner scan = new Scanner(System.in);
//		guess = scan.nextInt();//�û����������
//		
//		while(guess != num){
//			if(guess == 0){
//				System.out.println("���ź�����ӭ�´�������");
//				break;
//			}else if(guess < num){
//				System.out.println("̫С�ˣ�");			
//			}else if(guess > num){
//				System.out.println("̫���ˣ�");			
//			}
//			System.out.println("���ٴ�������µ����֣�1-10000�����˳�������0:");
//			guess = scan.nextInt();//�û����������	
//		}
//		scan.close();
//		while(guess == num){
//			System.out.println("��ϲ�����ˣ�");		
//			break;
//		}
	}
}
