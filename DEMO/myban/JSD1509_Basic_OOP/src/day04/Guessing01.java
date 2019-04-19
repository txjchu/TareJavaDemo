package day04;

import java.util.Scanner;
//猜数字	谜底为提前设置好！
public class Guessing01 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int num=250;
		System.out.println("请猜吧！");
		int guess;//定义在do前，因为while判断条件中需要用到guess。
		do{
			guess = scan.nextInt();
			if(guess == 0){
				System.out.println("真遗憾，下次再来！");
			}else if(guess > num){
				System.out.println("太大了！");
			}else if(guess < num){
				System.out.println("太小了！");
			}
		}while(guess != num);
		System.out.println("恭喜你答对了！");
		scan.close();
	}
}
