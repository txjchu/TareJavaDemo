package day03;
import java.util.Scanner;
//�ɼ��ȼ��ж�
public class Score {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ɼ�:");
		double score = scan.nextDouble();
		
		if(score<0 || score>100){
			System.out.println("�ɼ����Ϸ�");
		}else if(score>=90){
			System.out.println("A-����");
		}else if(score>=80){
			System.out.println("B-����");
		}else if(score>=60){
			System.out.println("C-�е�");
		}else{
			System.out.println("D-������");
		}
		
	}
}










