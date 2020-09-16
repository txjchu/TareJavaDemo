package Z1_FUNDAMENTAL;

import java.util.Scanner;

/**
 * 命令解析程序
 * @author: Peter
 * @date: 2020/5/23 16:52
 */
public class CommandBySwitch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请选择功能：1.显示全部记录 2.查询登记记录 0.退出");
        int command = scan.nextInt();
        switch(command){
            case 1:
                System.out.println("显示全部记录");
                break;
            case 2:
                System.out.println("查询登记记录");
                break;
            case 0:
                System.out.println("退出！感谢使用");
            default:
                System.out.println("输入错误");

        }

    }
}
