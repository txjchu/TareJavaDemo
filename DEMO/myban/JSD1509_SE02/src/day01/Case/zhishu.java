package day01.Case;
/**
 * 输出2-100之间的质数
 * @author Administrator
 *
 */
public class zhishu {
	public static void main(String[] args) {
		int count = 0;
		for(int i = 1; i <= 100; i ++){
			for(int j = 2; j <= i; j++){
				if(i == j){
					count ++;
					System.out.print(i +" ");
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
	}
}
