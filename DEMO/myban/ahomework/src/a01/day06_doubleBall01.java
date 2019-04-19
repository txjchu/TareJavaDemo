package a01;

import java.util.Arrays;
import java.util.Random;

/**
 * 1.pool ={01,02,03,...33}
 * 2.used ={ f, f, t,.....}
 * 3.balls={null,null,null,null,null,null}
 * 4.int i = 0 （判断是否取够6个球时使用）
 * 1) 生成随机数n,n的范围0<=n<33,
 * 2) 检查n对应的球的使用标记used[n]
 * 3) 如果使用过，则used[n]的值为true,返回1）
 * 4) 如果没有使用过，就取出球pool[n]，放入balls[i++]中
 * 		balls[i++] = pool[n]
 *    并将pool[n]对应的标记used[n]改为true，表示使用过
 * 5) 检查balls中球的数量，如果满了就结束，
 * 		balls满 = i==balls.length 
 * 6) 如果没满就返回1）
 * @author Administrator
 *
 */
public class day06_doubleBall01 {
	public static void main(String[] args) {
		//数据结构
		String[] pool = {"01","02","03","04","05","06","07","08","09","10","11","12","13",
				"14","15","16","17","18","19","20","21","22",
				"23","24","25","26","27","28","29","30","31","32","33"};
		boolean[] used = new boolean[pool.length];
		String[] balls = new String[6];
		int i = 0;
		//算法
		while(true){//另一种算法:do...while(i =! balls.length)
			Random ran = new Random();
			int n = ran.nextInt(pool.length);
			if(used[n]){
				continue;
			}
			balls[i++] = pool[n];
			used[n] = true; 
			if(i == balls.length){
				break;
			}
		}
//		错误的排序方法：
//		for(int j = 0; j <= balls.length; j++){  
//			if(balls[j] > balls[j+1]){		====字符串不能比较大小？
//				String str = balls[j];
//				balls[j] = balls[j+1];
//				balls[j+1] = str;
//			}
//		}
		Arrays.sort(balls);
		System.out.println(Arrays.toString(balls));
	}	
}
	
