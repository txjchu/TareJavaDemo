package day04;
import java.util.Scanner;
//����ӷ�������
public class Addition {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int score=0;   //�÷�
		
		for (int i=1;i<=10;i++){//��10����
			int a = (int)(Math.random() * 100);
			int b = (int)(Math.random() * 100);
			System.out.println("("+ i +")"+ a +"+"+ b +"= ?");
			System.out.println("������𰸣�����-1�˳�����");
			int answer = scan.nextInt();//��¼�û����������
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
		System.out.println("�˴β��Խ�������ĵ÷��ǣ�"+ score);
	}

}
