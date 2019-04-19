package day06;

import java.util.Scanner;

/**
 * 猜字母游戏
 * 1.数据结构
 * 1)char[] input用户输入猜测的字母组
 * 2)char[] chs自动生成的字母组
 * 3)int count计算猜测的次数
 * 4)int[] result将以上2组字母组对比后的结果
 * 2.程序算法
 * 1)generate()自动生成字母组的方法，返回一个字符型数组
 * 2)check(input,chs)将2个字母组做对比的方法，返回一个整数型数组int[] result
 * 3)主程序，接收用户输入并转换为字符型数组，重复调用2个方法，将最终结果显示 
 * @author Administrator
 *
 */
public class Guessing {
	public static void main(String[] args) {
		//1.数据类型
		int count = 0;//用于表示猜测的次数
		char[] input = null;//用来储存用户猜测的字母数组
		char[] chs = null;//用来储存自动生成的字母数组
		int[] result = new int[2];//用来储存每次对比后的结果
		//3)主程序
		Scanner scan = new Scanner(System.in);
		chs = generate();//自动生成一个字母数组
		System.out.println("GuessingGame>欢迎尝试猜字母游戏！");
		System.out.println(chs);//作弊
		System.out.println("GuessingGame>游戏开始，请输入你所猜的5个字母序列：（exit——退出）");
		while(true){
			String inputStr = scan.next().trim().toUpperCase();//接收用户输入的5个字母，并转换成大写，储存为字符串
			if("EXIT".equals(inputStr)){//如果用户输入exit，则结束
				System.out.println("GuessingGame>谢谢尝试猜字母游戏！再见！");
				break;
			}
			input = inputStr.toCharArray();//将字符串转换为char[]型数组
			result = check(input,chs);
			if(result[1] == chs.length){
				int score = 100 * chs.length - 10 * count;
				System.out.println("GuessingGame>恭喜你猜对了！你的得分是"+ score);
				break;
			}else{
				count++;
				System.out.println("GuessingGame>你猜对了"+ result[1] +"个字母，其中"
						+ result[0] +"个字母位置正确！（总猜了"+ count +"次，exit-退出）");
			}
		}
		scan.close();
	}
	
	//2.算法程序
	//1)自动生成字母数组的方法
	public static char[] generate(){
		char[] chs = new char[5];
		char[] letters ={'A','B','C','D','E','F','G','H','I','J','K','L','M',
				'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		boolean[] flags = new boolean[letters.length];//用来对字母的使用情况做标识，防止字母重复
		for(int i = 0; i < chs.length; i++){
			int num;
			do{
				num = (int)(Math.random()*(letters.length));//随机生成一个下标
			}while(flags[num]);//当flags[num]为false时，则停止循环
				chs[i] = letters[num];
				flags[num] = true;//flags[num]改为true，表示已经使用
			
		}
		return chs;
	}
	//2)将2个字母组做比较的方法
	public static int[] check(char[] input,char[] chs){
		int[] result = new int[2];//
		for(int i = 0; i < input.length; i++){
			for(int j = 0; j < chs.length; j++){
				if(input[i] == chs[j]){
					result[1]++;//如果有相同的字母，则将result[]第二个元素+1
					if(i == j){
						result[0]++;//如果字母的下标相同，则将result[]第一个元素+1
					}
					break;//如果猜对了某个字母，则跳出input[i]循环，进行下一次i++的对比
				}
			}
		}
		return result;
	}
	

}
