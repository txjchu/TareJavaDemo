package a01;

import java.util.Scanner;

//�жϳɼ��ĵȼ�
public class LevelForIf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ɼ���1-100֮�䣩��");
		double score = scan.nextDouble();
		scan.close();
		//�жϵȼ�
		if(0 > score || score > 100){
			System.out.println("������0��100֮������֣�");
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
			System.out.println("����");
		}
	}
}
