package day04;
import java.util.Scanner;
//随机加法运算器
public class Addition {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score = 0; //得分
		for(int i=1;i<=10;i++){ //出10道题
			int a = (int)(Math.random()*100); //加数a
			int b = (int)(Math.random()*100); //加数b
			int result = a + b; //存和
			System.out.println("("+i+")"+a+"+"+b+"=?"); //1.出题
			
			System.out.println("算吧!");
			int answer = scan.nextInt(); //2.答题
			
			if(answer==-1){ //若为-1时退出循环
				break;
			}else if(answer==result){ //3.判题
				score += 10; //答对一题加10分
				System.out.println("答对了");
			}else{
				System.out.println("答错了");
			}
		}
		System.out.println("总分为:"+score);
	}
}














