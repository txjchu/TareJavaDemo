package day02;
import java.util.Scanner;  //1.
//Scanner�÷�����ʾ
public class ScannerDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //2.
		System.out.println("����������:");
		int age = scan.nextInt(); //3.�����û���������ݲ���ֵ��age
		
		System.out.println(age);
	}
}







