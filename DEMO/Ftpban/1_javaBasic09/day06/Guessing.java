package day06;
import java.util.Scanner;
//猜字母游戏
public class Guessing {
	
	//主方法
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] chs = generate(); //获取随机字符数组
		System.out.println(chs); //作弊
		int count = 0; //猜错的次数
		while(true){ //自造死循环
			System.out.println("猜吧!");
			String str = scan.next().toUpperCase(); //获取用户输入的字符串，并转换为大写
			if(str.equals("EXIT")){ //判断字符串相等，需借助于equals()方法--后期详细讲
				System.out.println("下次再来吧!");
				break;
			}
			char[] input = str.toCharArray(); //将str转换为字符数组
			int[] result = check(chs,input); //对比:随机字符数组和用户输入的字符数组，返回对比的结果
			if(result[0]==chs.length){ //位置对为0说明全对
				int score = 100*chs.length-10*count; //一个字符100分，错一次扣10分
				System.out.println("恭喜你猜对了，得分:"+score);
				break;
			}else{ //猜错了
				count++; //猜错次数增1
				System.out.println("字符对:"+result[1]+"个，位置对:"+result[0]+"个");
			}
		}
	}
	
	//随机生成字符数组
	public static char[] generate(){
		char[] chs = new char[5];
		
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' }; //随机字符范围
		boolean[] flags = new boolean[letters.length]; //letters数组对应的开关数组
		for(int i=0;i<chs.length;i++){ //遍历随机字符数组
			int index; //字符数组下标
			do{
				index = (int)(Math.random()*letters.length); //生成0到25之间的随机数--充当letters数组的下标
			}while(flags[index]); //index对应的开关为true说明已存过，则再次重新生成index。当index对应的开关为false时，表明未存过，则退出循环
			chs[i] = letters[index]; //根据index下标去letters中获取相应的字符，并赋值给chs中的每一个元素
			flags[index] = true; //将index下标对应的开关修改为true，表明对应的字符已存过
		}
		
		return chs;
	}
	
	//对比:随机字符数组与用户输入的字符数组
	public static int[] check(char[] chs,char[] input){
		int[] result = new int[2]; //result[1]:字符对  result[0]:位置对
		for(int i=0;i<chs.length;i++){ //遍历随机字符数组
			for(int j=0;j<input.length;j++){ //遍历用户输入的字符数组
				if(chs[i]==input[j]){ //字符对
					result[1]++; //字符对个数增1
					if(i==j){ //位置对
						result[0]++; //位置对个数增1
					}
					break; //字符匹配之后，其余字符不需再判断了，提前退出当前循环
				}
			}
		}
		return result;
	}
	
}














