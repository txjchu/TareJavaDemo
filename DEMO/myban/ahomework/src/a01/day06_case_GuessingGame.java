package a01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 猜字母游戏
 * 1.设计数据结构
 * 1) 猜数字的次数（可以计算出得分）：int count
 * 2) 生成的字母数组：char[] chs
 * 3) 用户输入的字母数组：char[] input
 * 4) 2组数组对比后的结果（告知用户每一次猜测后的结果，1个表示字母和顺序都对，1个表示字母对顺序不对）：
 * 		int[] result = new int[2]
 * 2.设计程序结构
 * 1) 接收用户输入的数组的方法，并将结果返回给数组input；???
 * 2) 生成字母数组的方法，并将结果返回给数组chs：generate();
 * 3) 将input与chs两个数组对比的方法，并将结果返回给数组result：check();
 * @author Administrator
 *
 */
public class day06_case_GuessingGame {
	public static void main(String[] args) {
		int count = 0;//猜测的次数
		char[] input = null;//用户输入的数组
		char[] chs = null;//生成的数组
		int[] result = new int[2];//每次猜测后的结果
		//3.主程序设计
		chs = generate();//1)先调用generate()方法生成答案字母组
		System.out.println(Arrays.toString(chs));//作弊
		System.out.println("GuessingGame==>欢迎尝试猜字母游戏！");
		System.out.println("GuessingGame==>游戏开始，请输入你所猜的5个字母序列：（输入exit则退出）");
		Scanner scan = new Scanner(System.in);
		while(true){
			String inputStr = scan.next().trim().toUpperCase();//接收用户输入的5个字母
			if("EXIT".equals(inputStr)){//判断用户是否要退出
				System.out.println("GuessingGame==>谢谢你的尝试，再见！");
				break;
			}
			input = inputStr.toCharArray();//将字符串转换为字符型数组
			result = check(input,chs);//调用check()方法对比2个字母数组
			if(result[0] == input.length){//全部猜对的情况
				int score = 100 * input.length - 10 * count;//得分的计算
				System.out.println("GuessingGame==>恭喜你全猜对了！你的得分是："+ score);
				break;
			}else{
				count++ ;
				System.out.println("GuessingGame==>你猜对了"+ result[1] +"字母，其中"+ result[0]
				        +"个字母的位置正确！（总次数是"+count+"，输入exit则退出）" );
			}
		}
		scan.close();
	}
	//1.生成字母数组的方法
	public static char[] generate(){
		char[] chs = new char[5];
		char[] letters ={'A','B','C','D','E','F','G','H','I','J','K','L','M',
				'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'} ;//字母
		boolean[] flags = new boolean[letters.length];//使用情况
		for(int i = 0; i < chs.length; i++ ){
			int n;
			do{
				Random ran = new Random();
				n = ran.nextInt(26);//随机生成26个数字中的一个，作为从letters中选取字母的下标
//				n = (int)(Math.random() * (letters.length));//随机生成的另一种方法
			}while(flags[n]);//判断是否使用过，如果使用过，则循环do...while语句
			chs[i] = letters[n];
			flags[n] = true;
		};
		return chs;
	}
	//2.对比2个字母数组的方法，有2个数组参数，1个是用户输入的数组，1个是自动生成的数组
	public static int[] check(char[] input,char[] chs){
		int[] result = new int[2];//2个元素，第二个元素是用户猜对的字母数量，第一个元素是猜对的字母位置也正确的数量
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				if(input[i] == chs[j]){
					result[1]++;
					if(i == j){
						result[0]++;
					}
					break;
				}
			}
		}
		return result;
	}
	
}
