package day04;
import java.util.Scanner;
//����ӷ�������
public class Addition {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score = 0; //�÷�
		for(int i=1;i<=10;i++){ //��10����
			int a = (int)(Math.random()*100); //����a
			int b = (int)(Math.random()*100); //����b
			int result = a + b; //���
			System.out.println("("+i+")"+a+"+"+b+"=?"); //1.����
			
			System.out.println("���!");
			int answer = scan.nextInt(); //2.����
			
			if(answer==-1){ //��Ϊ-1ʱ�˳�ѭ��
				break;
			}else if(answer==result){ //3.����
				score += 10; //���һ���10��
				System.out.println("�����");
			}else{
				System.out.println("�����");
			}
		}
		System.out.println("�ܷ�Ϊ:"+score);
	}
}














