package a01;
//�ж�����
import java.util.Scanner;

public class nianling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("����������:");
		int age = scan.nextInt();
		scan.close();
		if(age >=18 && age <=30){
			System.out.println("�������ˡ�");
		}else{
			System.out.println("���������ˡ�");
		}
	}

}
