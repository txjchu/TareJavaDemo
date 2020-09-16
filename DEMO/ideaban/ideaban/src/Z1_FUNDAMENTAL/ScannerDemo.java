package Z1_FUNDAMENTAL;

import java.util.Scanner;

/**
 * Scanner 用法的演示
 * @author: Peter
 * @date: 2020/5/23 16:32
 */
public class ScannerDemo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入年龄：");
        int age = scan.nextInt();// 接收用户输入的数据并赋值给 age
        System.out.println(age);

    }
}
