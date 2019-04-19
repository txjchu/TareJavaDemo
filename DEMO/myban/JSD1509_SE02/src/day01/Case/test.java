package day01.Case;
/**
 * 质数的计算  2-100之间多少个质数
 * @author Administrator
 *
 */
public class test {
	public static void main(String[] args) {
/*		
		int count = 0;
		for(int i = 1; i <= 100; i ++){
			for(int j = 2; j <= i; j++){
				if(i == j){
					count ++;
					System.out.print(i + " ");
					if(count % 10 == 0){
						System.out.println();
					}
				}
				if(i % j == 0){
					break;
				}
			}
		}
		System.out.println("个数："+ count);
*/		
		
///*		
		int count = 0; //用于质数个数计数
		for(int i = 2; i <= 100; i ++){
			boolean flag = true;//假设i为质数
			//质数：只能被1和自身整除的自然数。一个数若没有被一个小于其平方根的数字整除，则必然不会被大于其平方根的数整除。
			for(int j = 2; j <= Math.sqrt(i); j ++){//设置条件时，不要设置j = i，会增加计算成本				
				if(i % j == 0){//若被其他数整除，则为非质数
					flag = false;
					break;//跳出当前循环
				}
			}
			if(flag){//代码读取到此处，若i是质数，即flag依旧为true
				count ++;//质数个数加1
				System.out.print(i + " ");
				if(count % 10 == 0){//每10个数字换一行
					System.out.println();
				}
			}
		}
		System.out.println("\n2-100之间一共有："+ count +"个质数。");
//*/
	}
}









