package a01;
//测试一个范围内的数字是否为水仙花数
/* 1.将一个数字分拆成几个单个数字
 * 2.判断是否为水仙花，sum == 1*1*1+2*2*2+3*3*3?
 * 3.判断一个范围内哪些数字为水仙花数
 */
public class day04_09_shuixian {
	public static void main(String[] args) {
		for(int i = 1; i <= 10000; i++){//3.设定范围			
			int num = i;			
			int sum = 0;
			while(true){//1.拆分多位数
				int d = num % 10;
				sum = sum + d*d*d;
							//★循环推导过程，循环结束的条件为num=0.	
				if(num == 0){//====不能是d==0,因为407，370两个数有单个位数为0
					break;
				}
				num /= 10;
//			System.out.println("d:" + d);
//			System.out.println(sum);
			}
//			System.out.println(sum);
			if(sum == i){//2.判断是否为水仙花数
				System.out.println(i +"是水仙花数");
			}
		}
	}
}
