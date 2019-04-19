package a01;

import java.util.Scanner;

//判断成绩的等级
public class LevelForIf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入成绩（1-100之间）：");
		double score = scan.nextDouble();
		scan.close();
		//判断等级
		if(0 > score || score > 100){
			System.out.println("请输入0到100之间的数字！");
		}else if(score >= 90){
			System.out.println("A");
		}else if(score >= 80){
			System.out.println("B");
		}else if(score >= 70){
			System.out.println("C");
		}else if(score >= 60){
			System.out.println("D");
		}else if(score < 60){
		//}else {
			System.out.println("其他");
		}
	}
}
