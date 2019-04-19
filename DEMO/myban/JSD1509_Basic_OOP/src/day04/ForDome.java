package day04;
//for循环演示
public class ForDome {

	public static void main(String[] args) {
		/*
		for(int i=0,j=6;i<5;i+=2,j-=2){
		}
		*/
		/*
		 * i=0,j=6
		 * i=2,j=4
		 * i=4,j=2
		 * i=6,j=0
		 */
		
		/*
		//没有条件的循环就是死循环
		for(;;){
			System.out.println("我要学习");
		}
		*/
		
		/*
		int sum = 0; 
		for(int num=1;num<=100;){
			sum += num;
			num++;
		}
		System.out.println("sum="+sum);
		*/
		
		/*
		int sum = 0;
		int num=1;
		for(;num<=100;num++){
			sum += num;
		}
		System.out.println("sum="+sum);
		*/

		
		/*
		int sum = 0; 
		for(int num=1;num<=100;num++){
			//只要个位不为3的
			if(num%10!=3){
				sum += num;
			}
		}
		System.out.println("sum="+sum);
		*/
		
		/*
		int sum = 0; 
		for(int num=1;num<=100;num++){
			//跳过个位为3的
			if(num%10==3){
				continue; //跳过循环体中剩余语句而进入下一次循环
			}
			sum += num;
		}
		System.out.println("sum="+sum);
		*/
		
		/*
		 * sum=0
		 * num=1 sum=1
		 * num=2 sum=1+2
		 * num=3 
		 * num=4 sum=1+2+4
		 * ...
		 * num=13 
		 * num=14 sum=1+2+4+5+...12+14
		 */

		
		/*
		//累加和: 1+2+3+4+...+100=?
		int sum = 0; //存和
		for(int num=1;num<=100;num++){
			sum += num;
		}
		System.out.println("sum="+sum);
		*/
		
		/*
		 *       sum=0
		 * num=1 sum=1
		 * num=2 sum=1+2
		 * num=3 sum=1+2+3
		 * num=4 sum=1+2+3+4
		 * ...
		 * num=100 sum=1+2+3+4+...+100
		 */
		
		
		
		/*
		for(int num=1;num<=9;num++){
			System.out.println(num+"*9="+num*9);
		}
		System.out.println("over");
		*/
		
		/*
		for(int times=0;times<10;times++){
			System.out.println("行动是成功的阶梯");
		}
		System.out.println("over");
		*/
		/*
		 * 执行过程:
		 * times=0 true 输出
		 * times=1 true 输出
		 * times=2 true 输出
		 * times=3 true 输出
		 * times=4 true 输出
		 * times=5 true 输出
		 * times=6 true 输出
		 * times=7 true 输出
		 * times=8 true 输出
		 * times=9 true 输出
		 * times=10 false for循环结束
		 * 输出over
		 */		

	}

}
