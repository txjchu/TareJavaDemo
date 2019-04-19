package a01;

import java.util.Scanner;

//Switch的命令解析程序
public class day03_c05_CommandBySwitch {
	public static void main(String[] args) {
		System.out.println("请选择功能：1.显示全部记录  2.查询登录记录  0.退出");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		switch(a){
		case 1:
			System.out.println("全部记录！");
			break;
		case 2:
			System.out.println("登录记录！");
			break;
		case 0:
			System.out.println("欢迎使用！");
			break;
		default:
			System.out.println("输入有误！");
		}
	}

}
