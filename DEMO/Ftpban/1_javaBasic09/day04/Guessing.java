package day04;
import java.util.Scanner;
//��������Ϸ
public class Guessing {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = (int)(Math.random()*1000+1); //�������1��1000֮�ڵ���
		System.out.println(num); //����
		
		int guess;
		do{
			System.out.println("�°�!");
			guess = scan.nextInt(); //1.+3.
			if(guess==0){
				break;
			}else if(guess>num){
				System.out.println("̫����");
			}else if(guess<num){
				System.out.println("̫С��");
			}
		}while(guess!=num); //2.
		if(guess==num){
			System.out.println("��ϲ�㣬�¶���!");
		}else{
			System.out.println("�´�������!");
		}
		
		/*
		System.out.println("�°�!");
		int guess = scan.nextInt(); //1.
		while(guess!=num){ //2.
			if(guess==0){
				break;
			}else if(guess>num){
				System.out.println("̫����");
			}else{
				System.out.println("̫С��");
			}
			System.out.println("�°�!");
			guess = scan.nextInt(); //3.
		}
		if(guess==num){
			System.out.println("��ϲ�㣬�¶���!");
		}else{
			System.out.println("�´�������!");
		}
		*/
		
	}
}










