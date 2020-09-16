package Z1_FUNDAMENTAL;

import org.junit.Test;

import java.util.Scanner;

/**
 * 闰年的判断
 * @author: Peter
 * @date: 2020/5/23 17:11
 */
public class LeapYear {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//            System.out.println("请输入年份：");
//            int year = s.nextInt();
        int year;
        do {
            System.out.println("请输入年份：");
            year = s.nextInt();
            if(year == 0){
                System.out.println("结束程序！");
                return;
            }
            boolean flag = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
            String msg = flag ? year +"是闰年" : year +"不是闰年";
            System.out.println(msg);
        } while (year != 0);
    }

    @Test
    public void testFor(){
        Scanner s = new Scanner(System.in);
        int year ;
        for(int i = 0; i < 10; i ++){
            System.out.println("请输入年份：");
            year = s.nextInt();
            /**
             * return 结束当前方法
             * break 跳出当前循环体， break outer; 跳出 outer: 标签标示的循环（如外层 for 循环的上一层使用 outer: 标识符后，就可以使用 break outer; 跳出）
             * continue 终止本次循环，进入到下一循环
             */
            if(year == 0){
                System.out.println("结束程序！");
//                return;
                break;
            }
            boolean flag = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
            String msg = flag ? year + "是闰年" : year +"不是闰年";
            System.out.println(msg);


        }
    }

    /*
     * IntelliJ IDEA控制台junit不能用Scanner输入
     * https://blog.csdn.net/u010999809/article/details/88733014
     * 需要给启动的 vmoptions 添加一个选项 -Deditable.java.test.console=true
     */
    @Test
    public void testScanner(){
        // Test 中不能使用 Scanner 吗
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = scanner.nextInt();
        System.out.println("输入的年份是"+ year);

    }

}
