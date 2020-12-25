package nowcoder_HUAWEI;

import java.util.Scanner;

/**
 * 1. 计算一个字符串最后一个单词长度，单词用空格隔开
 * 思路：本题使用split()方法将字符串按空格切割成字符串数组保存即可，数组最后一个元素（字符串）的长度即为答案。
 * @author: Peter
 * @date: 2020/12/20 22:11
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("请输入一段英文：");
        System.out.println(lengthOfLastWord(str));

    }

    public static int lengthOfLastWord(String str){
        String[] strs = str.split(" ");
        return strs[strs.length - 1].length();
    }
}
