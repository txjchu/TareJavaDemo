package day04;
import java.util.Scanner;
//随机加法运算器
public class Addition {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int score=0;   //得分
		
		for (int i=1;i<=10;i++){//出10道题
			int a = (int)(Math.random() * 100);
			int b = (int)(Math.random() * 100);
			System.out.println("("+ i +")"+ a +"+"+ b +"= ?");
			System.out.println("请输入答案（输入-1退出）：");
			int answer = scan.nextInt();//记录用户输入的数字
			if(answer == -1){
				break;
			}else if(answer == a + b){
				System.out.println("Correct!");
				score += 10;
			}else{
				System.out.println("Error!");
			}
		};
		scan.close();
		System.out.println("此次测试结束，你的得分是："+ score);
	}

}
