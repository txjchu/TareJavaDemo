package a01;

import java.util.Scanner;

/**
 * 猜字母游戏09（加游戏等级功能）
 * 1.数据结构设计
 * 1) int count 用于计数，用户猜测的次数
 * 2) int level 用于储存游戏等级
 * 3) char[] input 用于储存用户输入的字母数组
 * 4) char[] chs 用于储存自动生成的字母数组
 * 5) int[] result 用于储存两组数据对比后的结果
 * 2.算法程序设计
 * 1) generate() 自动生成字母数组的方法，参数：level，返回值：char[] chs
 * 2) check() 两组数组对比的方法，参数：input,chs，返回值：int[] result
 * 3.主程序
 * 1) 游戏等级设置
 * 2) 接收用户输入的字母数组，并调用生成数组方法，调用比较数组方法，人机交互
 * @author Administrator
 *
 */
public class aaa {
	public static void main(String[] args) {
		//1.数据结构
		int count = 0;//用户猜测的次数
		int[] result = new int[2];//两组数组对比后的结果
		Scanner scan = new Scanner(System.in);
		System.out.println("GuessingGame==>欢迎尝试猜字母游戏（加设置等级功能）！");
		int level = 5;//游戏等级
		do{//用户设置游戏等级
			System.out.println("GuessingGame==>请输入游戏等级（5，7，9）");
			level = scan.nextInt();
		}while(level != 5 && level != 7 && level !=9);
		char[] chs = generate(level);//自动生成的字母数组
		System.out.println(chs);//作弊
		System.out.println("GuessingGame==>游戏开始！请输入你所猜测的"+ level +"个字母序列（输入exit=退出）");
		
		while(true){
			String inputStr = scan.next().trim().toUpperCase();//接收用户输入的字母序列，并去空白，并大写化
			if("EXIT".equals(inputStr)){//如果用户输入exit，则退出游戏
				System.out.println("GuessingGame==>谢谢尝试猜字母游戏，再见！");
				break;
			}
			char[] input = inputStr.toCharArray();//用户输入的字母数组,并将其转化为字符型数组
			result = check(input,chs);//调用对比数组的方法
			if(result[0] == chs.length){//如果用户全猜对，则结束游戏，并给出得分
				int score = 100 * chs.length - 10 * count;
				System.out.println("GuessingGame==>恭喜你全猜对了，你的得分是"+ score);
				break;
			}else{
				count++;//如果猜错了则猜测次数加1
				System.out.println("GuessingGame==>你猜对了"+ result[1] +"个字母，其中"
						+ result[0] +"个字母位置正确，（总猜测次数为："+ count +"次，exit=退出）");
			}
		}
		scan.close();
	}
	//2.算法结构
	/**
	 * 2.1 自动生成数组的方法
	 * @param level
	 * 			游戏等级，作为chs数组的长度
	 * @return chs
	 * 			自动生成的字母数组
	 */
	public static char[] generate(int level){
		char[] chs = new char[level];//存储自动生成的数组
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z'};
		boolean[] flags = new boolean[letters.length];
		for(int i = 0; i < chs.length; i++){
			int index;//下标
			do{
				index = (int)(Math.random() * (letters.length));
			}while(flags[index]);//去重复
			chs[i] = letters[index];
			flags[index] = true;	
		}		
		return chs;
	}
	/**
	 * 2.2 两组数组做对比的方法
	 * @param input
	 * 			用户输入的字母数组
	 * @param chs
	 * 			自动生成的字母数组
	 * @return result
	 * 			两组数组做对比后的结果
	 */
	public static int[] check(char[] input,char[] chs){
		int[] result = new int[2];
		for(int i = 0; i < input.length; i++){
			for(int j = 0; j < chs.length; j++){
				if(input[i] == chs[j]){//如果字母相同，则第二个元素加1
					result[1]++;
					if(i == j){//如果相同字母的位置也相同，则第一个元素加1
						result[0]++;
					}
					break;
				}
			}
		}
		return result;
	}
}
