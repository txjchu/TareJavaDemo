package a01;

import java.util.Scanner;

/**
 * 1.出10道加法题（加数在0-99之间）
 * 2.判断用户答题
 * 3.几分
 * @author Administrator
 *
 */
public class day04_case_03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("将开始加法测试：");
		int score = 0;//得到的分数
		int count = 0;//答对多少道题
		for(int i = 1; i <= 10; i++){//1.出10道题
			int a = (int) (Math.random()* 100) ;//包含0，也包含 99
			int b = (int) (Math.random()* 100) ;
			System.out.println("("+ i +")"+ a +"+"+ b +"= ?");
			System.out.println("请输入答案（输入-1退出）：");
			int answer = scan.nextInt();
			if(answer == -1){//用户输入-1退出，并输出分数
				System.out.println("此次测验结束，您的分数是："+ score);
				break;
			}else if(answer == a+b){//2.判断是否答题正确
				score += 10;//3.计分，对1题加10分
				count ++;
				System.out.println("Correct!");	
			}else {
				System.out.println("Error!");
			}
				
		}
		scan.close();//关闭Scanner对象
		System.out.println("恭喜你，共答对"+ count +"道题，得到"+ score +"分！");
	}
}
