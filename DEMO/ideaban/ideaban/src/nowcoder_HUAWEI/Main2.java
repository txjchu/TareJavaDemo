package nowcoder_HUAWEI;

import java.util.Scanner;

/**
 * 2. 题目描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写。
 *
 * 输入描述:
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 * @author: Peter
 * @date: 2020/12/20 22:19
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个由字母、数字和空格组成的字符串：");
        String org = sc.nextLine();
        System.out.println("请输入一个字母：");
        char let = sc.nextLine().charAt(0);
        System.out.println("字母 "+ let +" 在 "+ org +"中出现的次数为："+ count1(org, let));

    }

    public static int count(String org, char let){
        int count = 0;
        do {
            count ++;
            org = org.substring(org.charAt(let) != -1 ? org.charAt(let) : org.length() - 2); // StringIndexOutOfBoundsException
        }while (org.charAt(let) != -1);


        return  count;
    }

    public static int count1(String org, char let){
        int count = 0;
        char[] chars = org.toCharArray();
        for(char c : chars){
            if (Character.toLowerCase(c) == Character.toLowerCase(let)){  // 必须区分大小写
                count ++;
            }
        }
        return count;
    }
}
