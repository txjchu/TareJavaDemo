package a01;

import java.util.Arrays;
import java.util.Random;

/**
 * 自己的思路真双色球	33个数  取  6个红球，16个数  取  1个蓝球（未完成蓝色球）
 * 1.
 * @author Administrator
 *
 */
public class day06_doubleBallsDome {
	public static void main(String[] args) {
		//33个数取6个红球
		String[] redBalls = {"00","01","02","03","04","05","06","07","08",
				"09","10","11","12","13","14","15","16","17","18","19",
				"20","21","22","23","24","25","26","27","28","29",
				"30","31","32"};
		String[] blueBalls = {"00","01","02","03","04","05","06","07","08",
				"09","10","11","12","13","14","15",};
//		System.out.println(Arrays.toString(redBalls));
//		System.out.println(Arrays.toString(rb));
		String[] balls = new String[7];//7个双色球数组
		
		//生成红球
		int[] rb = generateArray(6,33);//生成6个红色球的下标
		for(int i = 0; i < 6; i ++){
			balls[i] = redBalls[rb[i]]; //用生成的6个红色球下标生成6个红球，放入双色球前6位中
		}
		System.out.println("双色球中6个红球的号码是："+ Arrays.toString(balls));
		//生成蓝球
		int[] bb = generateArray(1,16);
		balls[6] = blueBalls[bb[0]];
		System.out.println("双色球7个号码是："+ Arrays.toString(balls));
	}
	//随机取球方法(即随机数组)
	public static int[] generateArray(int length,int max){
		int[] arr = new int[length];//定义数组，长度为length(即红6，蓝1)
		Random ran = new Random();
		for(int i = 0; i < arr.length; i++){
			arr[i] = ran.nextInt(max);//取数范围，0<=x<max(max正好为redBalls的长度)
			for(int j = 0; j < i; j++){
				if(arr[j] == arr[i]){
					i -- ;//去除重复生成的数字，让arr[i]重新生成
					continue;
				}
			}
		}
		return arr;
	}
	
}
