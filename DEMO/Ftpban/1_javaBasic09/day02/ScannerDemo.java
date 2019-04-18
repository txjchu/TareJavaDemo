package day02;
import java.util.Scanner;  //1.
//Scanner用法的演示
public class ScannerDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //2.
		System.out.println("请输入年龄:");
		int age = scan.nextInt(); //3.接收用户输入的数据并赋值给age
		
		System.out.println(age);
	}
}







