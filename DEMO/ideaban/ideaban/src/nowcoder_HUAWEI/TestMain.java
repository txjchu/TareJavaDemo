package nowcoder_HUAWEI;

import org.junit.Test;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 在idea的junit单元测试中用Scanner
 *
 * 1.通过IDEA工具Help-Edit Custom VM Options打开配置文件位置
 * 2.修改上一步打开的配置文件idea64.exe.vmoptions，在最后一行添加：
 * -Deditable.java.test.console=true
 * 3.重启IDEA
 *
 * @author: Peter
 * @date: 2020/12/20 23:09
 */
public class TestMain {


    /**
     * 3. 题目描述
     * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
     *
     * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
     *
     * 当没有新的输入时，说明输入结束。
     *
     * 输入描述:
     * 注意：输入可能有多组数据。每组数据都包括多行，第一行先输入随机整数的个数N，接下来的N行再输入相应个数的整数。具体格式请看下面的"示例"。
     *
     * 输出描述:
     * 返回多行，处理后的结果
     *
     * https://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0
     */
    @Test
    public void test3(){
        Scanner sc = new Scanner(System.in);
        // 一直接收，直到接收到停止命令。默认ctrl+z ，或者给终止符 hasNext("0")
        while(sc.hasNext()){
            int n = sc.nextInt();   // 数组个数由输入得到
            TreeSet<Integer> treeSet = new TreeSet<>();
            if (n > 0){
                for(int i = 0; i < n; i++){
                    treeSet.add(sc.nextInt());
                }
            }
            for (Integer i : treeSet){
                System.out.println(i);
            }
        }
    }

    /**
     * 4. 题目描述
     * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
     * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     *
     * 输入描述:
     * 连续输入字符串(输入多次,每个字符串长度小于100)
     *
     * 输出描述:
     * 输出到长度为8的新字符串数组
     *
     * 输入：
     * abc
     * 123456789
     * 输出：
     * abc00000
     * 12345678
     * 90000000
     */
    @Test
    public void test4(){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = null;
        while(sc.hasNext()){
            String str = sc.nextLine();
            int nextTimes = str.length() % 8;
            sb = new StringBuilder(str);
            if(nextTimes != 0){
                for(int i = 0; i < (8 - nextTimes); i ++){
                    sb.append("0");
                }
            }
            String str1 = sb.toString();
            while(str1.length() > 0){
                System.out.println(str1.substring(0, 8));
                str1 = str1.substring(8);
            }
        }
    }

    /**
     * 5. 输入描述:
     * 输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据，请参考帖子https://www.nowcoder.com/discuss/276处理多组输入的问题。
     *
     * 输出描述:
     * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
     *
     * 输入:
     * 0xA
     * 0xAA
     * 输出：
     * 10
     * 170
     */
    @Test
    public void test5(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            str = str.substring(2);
            char[] chars = str.toCharArray();
            int a = 0;
            for (int i = chars.length - 1; i >= 0; i --){
                a = a * 16 + hexToInt(chars[i]);
            }
            System.out.println(a);
        }


    }

    public static int hexToInt(char c){
//        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        c = String.valueOf(c).toUpperCase().charAt(0);
        if (c >= 'A' && c <= 'F'){
            return c + 10 - 'A';
        } else {
            return c - '0';
        }
    }
    @Test
    public void test51(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(hexToInt(str.charAt(0)));
    }

    public static void main(String[] args){
        System.out.println('a' + 0);
        System.out.println('A'+ 0);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            str = str.substring(2);
            char[] chars = str.toCharArray();
            int a = 0;
            for (int i = 0; i <= chars.length - 1; i ++){
                a = a * 16 + hexToInt(chars[i]);
            }
            System.out.println(a);
        }
    }


    /**
     * 题目描述
     * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
     *
     * 最后一个数后面也要有空格
     *
     * 输入描述:
     * 输入一个long型整数
     *
     * 输出描述:
     * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
     * 输入：
     * 180
     * 输出：
     * 2 2 3 3 5
     */
    @Test
    public void test6(){
        Scanner sc = new Scanner(System.in);
        long num = Long.parseLong(sc.nextLine());
        getPrimer(num);
    }
    // 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
    //case通过率为91.67%
    public static void getPrimer(long num){
        for (int i = 2; i <= num; i++){
            if (num % i == 0) {     // 如果数字除以 i 余为 0，则 i 表示其因子，又因为 i 是从 2 开始，且一旦能够整除，则从数字中除去 i 同时递归调用，再将比 i 小的因子除出。
                System.out.print(i +" ");
                getPrimer(num); // 递归调用，每次除去一个因子 都会输出一次，直到再也没有因子时跳出 for 循环，执行第二个 if
                break;
            }
            if (i == num){
                System.out.print(i +" ");
            }
        }
    }
    @Test
    public void test61(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long num = sc.nextLong();
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= num; i ++){
                while(num % i == 0){
                    sb.append(i).append(" ");
                    num = num / i;
                }
            }
            System.out.println(sb);
        }
    }
}
