package a01;
//判断年龄
import java.util.Scanner;

public class nianling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入年龄:");
		int age = scan.nextInt();
		scan.close();
		if(age >=18 && age <=30){
			System.out.println("是青年人。");
		}else{
			System.out.println("不是青年人。");
		}
	}

}
