package a01;
/**
 * 查找一个范围内的所有质数
 * 质数：大于1的数，可以被1整除。可以被自身整除，不能被其他数整除。
 * @author Administrator
 * 1.判断一个数是否为质数
 * 2.找出一个范围内的所有质数
 * 3.打印出所有的质数
 */
public class day04_zhishu {
	public static void main(String[] args) {
		System.out.print("1-10之内的质数有：");
		for(int j = 1; j < 10; j++){//2.设置判断范围
			boolean isPrime = true;// Prime number：质数
			for(int i = 2;i <= j / 2;i ++){//i的范围是[2,j/2]//1.判断质数
				int m = j % i;
				if(m == 0){
					isPrime = false;
	//				System.out.println(j +"不是质数");
					break;//跳出for循环----也可以用continue(跳过)
				}
			}
			if(isPrime){//设置isPrime为true，用来避免小于4的数字因为不能进入for循环而被错误判断。
				System.out.print(j +"，");//3.打印输出
			}		
		}
//================================带标号的continue的用法。标号next(可更改)
		nexe:for(int num = 2; num <= 100; num ++){
				for(int i = 2; i <= num/2; i++){
					if(num % i == 0){
						continue nexe;//打断当前循环，继续执行标号为nexe对应的外层循环
					}
				}
			System.out.println(num +"是质数");	
		}
	}
}
