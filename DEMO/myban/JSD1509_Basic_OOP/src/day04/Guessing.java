package day04;

import java.util.Scanner;

//猜数字游戏
public class Guessing {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int num=(int)(Math.random()*1000+1);//藏起来的那个数,随机生成1-1000之内的数字。
		//Math.random()*1000+1;Math.random随机生成一个0.0-0.99999....之间的一个数字
		
		//System.out.println(num);//作弊
		int guess;
		do{
			System.out.println("猜吧！");
			guess=scan.nextInt();   //1.
			if(guess==0){
				System.out.println("下次再来吧");
				break;
			}else if(guess>num){
				System.out.println("太大了");
				
			}else {
				System.out.println("太小了");
			}
			System.out.println("猜吧！");
			guess=scan.nextInt();     //3.
		}while(guess!=num);   //2.
		if(guess==num){
			System.out.println("恭喜你，猜对了！");
		}
		
		
		/*
		System.out.println("猜吧！");
		int guess=scan.nextInt();   //1.
		while(guess!=num){     //2.
			if(guess==0){
				System.out.println("下次再来吧");
				break;
			}
			if(guess>num){
				System.out.println("太大了");
				
			}else{
				System.out.println("太小了");
			}
			System.out.println("猜吧！");
			guess=scan.nextInt();     //3.
			}
		if(guess==num){
			System.out.println("恭喜你答对了！");
		}
			*/
			
/*
 * 1.藏起来一个数num
 * 2.循环三要素
 * 3.
 * 
 * 
 * 
 * 给变量赋值：
 * 1）int num=5;
 */
	}

}
