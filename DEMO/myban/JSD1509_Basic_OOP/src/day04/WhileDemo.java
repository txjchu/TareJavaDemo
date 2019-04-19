package day04;

public class WhileDemo {
//while演示
	public static void main(String[] args) {
		
		/*
		//案例2
		//输出9的乘法表
		//2*9=18
		int num=1;          //1.
		while (num<=9){     //2.
			System.out.println(num+"*9="+num*9);
			num++;          //3.
		}
		System.out.println("over");
		*/
		/*
		int num=1;
		while (num<=9){
			System.out.println(num+"*9="+num*9);
			num++;
		
		}
		System.out.println("over");
		*/
		int sum=0;//存和
		for(int num=1;num<=100;num++){
			//sum=sum+num;
			sum+=num;
		}
		System.out.println("sum="+sum);
		/*
		 * int sum=0;
		 * for(int num=1;num<=100;num++){
		 * 	sum+=num; 
		 * }
		 * System.out.println("sum="+sum);
		 */
		/*
		 * 执行过程：
		 * num=1  true  输出
		 * num=2  true  输出
		 * num=3  true  输出
		 * num=4  true  输出
		 * num=5  true  输出
		 * num=6  true  输出
		 * num=7  true  输出
		 * num=8  true  输出
		 * num=9  true  输出
		 * num=10  false  while循环结束
		 * 输出over
		 */
		
		
		
		/*
		 //案例1
		 int times=0;  //1.循环变量的初始化
		 
		while (times<10){//2.循环的条件
			System.out.println("行动是成功的第一要素");	
			times++;     //3.循环变量的改变
		}
		System.out.println("over");
		/*
		 * 执行过程：
		 * times=0  true  输出
		 * times=1  true  输出
		 * times=2  true  输出
		 * times=3  true  输出
		 * times=4  true  输出
		 * times=5  true  输出
		 * times=6  true  输出
		 * times=7  true  输出
		 * times=8  true  输出
		 * times=9  true  输出
		 * times=10 false  while循环结束
		 * 输出over
		 */
	}

}
