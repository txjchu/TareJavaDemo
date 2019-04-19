package a01;

import java.util.Scanner;

/**
 * 猜字母游戏升级版（加游戏等级）
 * 1.数据结构
 * 1)int count用户猜字母的次数
 * 2)char[] input用户所猜字母数组
 * 3)char[] chs自动生成的字母数组
 * 4)int[] result每次将2个字母数组做对比后的结果
 * 5)int level游戏等级
 * 2.算法程序
 * 1)generate(int level);自动生成字母数组的方法，传入level游戏等级表示数组元素个数
 * 2)check(char[] input,char[] chs);将2个数组做对比的方法
 * 3)主程序，a.接收用户输入的游戏等级，b.接收用户输入的字母，并将其转化为数组，
 * 			c.调用生成字母数组的方法，调用对比数组方法
 * @author Administrator
 *
 */
public class day06_02_GuessingGame {
	public static void main(String[] args) {
		//1.数据设计
		int count = 0;//用于计算用户猜字母的次数
		char[] input = null;//用于接收用户输入
		char[] chs = null;//用于接收自动生成的字母数组
		int[] result = new int[2];//接收对比结果
		int level = 5;//默认游戏等级为5
		//3)设计主程序
		Scanner scan = new Scanner(System.in);
		System.out.println("GuessingGame==>欢迎尝试猜字母游戏！");
		do{//a.用户输入设置游戏级别
			System.out.println("GuessingGame==>请输入游戏级别（5，7，9）：");
			level = scan.nextInt();
		}while(level != 5 && level != 7 && level != 9);
		//b.接收用户数输入的字母
		chs = generate(level);//调用方法生成随机字母数组
		System.out.println(chs);//作弊
		System.out.println("GuessingGame==>游戏开始，请输入你所猜的"+ level +"个字母序列（exit--退出）：");
		while(true){
			String inputStr = scan.next().trim().toUpperCase();
			if("EXIT".equals(inputStr)){
				System.out.println("GuessingGame==>谢谢尝试猜字母游戏，再见！");
				break;
			}
			input = inputStr.toCharArray();
			result = check(input,chs);
			int score = 100 * chs.length - 10 * count;
			if(result[0] == chs.length){
				System.out.println("GuessingGame==>恭喜你全猜对了，总得分为"+ score);
				break;
			}else{
				count++;
				System.out.println("GuessingGame==>你猜对了"+ result[1] +"个字母，其中"
						+ result[0] +"个字母位置正确（总次数为"+ count +",exit--退出）");
			}
		}
		
		
		scan.close();
	}
	//2.算法程序
	//1)自动生成字母数组的方法
	public static char[] generate(int level){
		char[] chs = new char[level];
		char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L',
				'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		boolean[] flags = new boolean[letters.length];
		int index;
		for(int i = 0; i < chs.length; i++){//自动生成chs.length个字符元素
			do{
				index = (int)(Math.random() * (letters.length));//随机生成字母下标				
			}while(flags[index]);//如果生成下标对应的flags[index]为true，则重新生成，避免重复
			chs[i] = letters[index];
			flags[index] = true;
		}
		return chs;
	}
	//2)将2个字母数组做对比的方法
	public static int[] check(char[] input,char[] chs){
		int[] result = new int[2];//用于储存对比结果
		for(int i = 0; i < input.length; i++){
			for(int j = 0; j < chs.length; j++){
				if(input[i] == chs[j]){
					result[1]++;//如果字母相同，则第二个元素加1
					if(i == j){
						result[0]++;//如果相同字母的下标也相等，则第一个元素加1
					}
					break;//字母相同，则退出内循环，
				}
			}
		}
		return result;
	}
}
