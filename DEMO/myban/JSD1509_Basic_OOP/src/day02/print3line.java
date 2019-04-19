package day02;
/**
 * 打印正三角形-------这是直角三角形，- -！
 * @author Administrator
 *
 */
public class print3line {
	public static void main(String[] args) {
		for(int i = 0; i < 6; i ++){
			for(int j = 0; j < i; j ++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
