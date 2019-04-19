package a01;

import java.util.Scanner;

//猜数字
public class day04_guess {
	public static void main(String[] args) {
//=============V2.0,do...while
		int num = (int) (Math.random()* 1000)+ 1;
		
//		System.out.println("请输入你猜的数字（1-1000），输入0退出：");=======放入do语句中
		Scanner scan = new Scanner(System.in);
		int guess = -1;//====设置初始值
		do{
			System.out.println("请输入你猜的数字（1-1000），输入0退出：");
			guess = scan.nextInt();
			if(guess == 0){
//				System.out.println("真遗憾！下次再来！");
				break;
			}else if(guess < num){
				System.out.println("太小了！");				
			}else if(guess > num){
				System.out.println("太大了！");				
			}
		}while(guess != num);
		scan.close();
		if(guess == num){
			System.out.println("恭喜你答对了！");
		}else{
			System.out.println("真遗憾！");
		}

//=============V1.0,while		
////		int num = 5;//先储存一个数字谜底
//		int num = (int) (Math.random()* 1000)+ 1;//0.0-0.9999...?+1
//		
//		int guess ;
//		System.out.println("请输入你猜的数字（1-1000），退出请输入0:");
//		Scanner scan = new Scanner(System.in);
//		guess = scan.nextInt();//用户输入的数字
//		
//		while(guess != num){
//			if(guess == 0){
//				System.out.println("真遗憾！欢迎下次再来！");
//				break;
//			}else if(guess < num){
//				System.out.println("太小了！");			
//			}else if(guess > num){
//				System.out.println("太大了！");			
//			}
//			System.out.println("请再次输入你猜的数字（1-10000），退出请输入0:");
//			guess = scan.nextInt();//用户输入的数字	
//		}
//		scan.close();
//		while(guess == num){
//			System.out.println("恭喜你答对了！");		
//			break;
//		}
	}
}
