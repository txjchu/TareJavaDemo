package a01;

import java.util.Scanner;

/**
 * 1.��10���ӷ��⣨������0-99֮�䣩
 * 2.�ж��û�����
 * 3.����
 * @author Administrator
 *
 */
public class day04_case_03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("����ʼ�ӷ����ԣ�");
		int score = 0;//�õ��ķ���
		int count = 0;//��Զ��ٵ���
		for(int i = 1; i <= 10; i++){//1.��10����
			int a = (int) (Math.random()* 100) ;//����0��Ҳ���� 99
			int b = (int) (Math.random()* 100) ;
			System.out.println("("+ i +")"+ a +"+"+ b +"= ?");
			System.out.println("������𰸣�����-1�˳�����");
			int answer = scan.nextInt();
			if(answer == -1){//�û�����-1�˳������������
				System.out.println("�˴β�����������ķ����ǣ�"+ score);
				break;
			}else if(answer == a+b){//2.�ж��Ƿ������ȷ
				score += 10;//3.�Ʒ֣���1���10��
				count ++;
				System.out.println("Correct!");	
			}else {
				System.out.println("Error!");
			}
				
		}
		scan.close();//�ر�Scanner����
		System.out.println("��ϲ�㣬�����"+ count +"���⣬�õ�"+ score +"�֣�");
	}
}
