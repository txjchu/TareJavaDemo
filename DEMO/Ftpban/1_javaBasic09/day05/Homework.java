package day05;
//��ҵ����
public class Homework {
	public static void main(String[] args) {
		//1/1+1/2+1/3+...+1/15=?
		int n = 15;
		double sum = 0; //��
		for(int i=1;i<=n;i++){
			sum += 1.0/i;
		}
		System.out.println("sum="+sum);
		
		
		/*
		//9+99+999+9999+...+9999999999=?
		long sum = 0; //��
		long num = 0; //����(9/99/999...)
		for(int i=1;i<=10;i++){
			num = num*10+9;
			sum = sum + num;
		}
		System.out.println("sum="+sum);
		*/
		/*
		 * i=1 num=9    sum=9
		 * i=2 num=99   sum=9+99
		 * i=3 num=999  sum=9+99+999
		 */
		
		/*     
		 *     num=0     num=num *10+9
		 * i=1 num=9     num=0   *10+9
		 * i=2 num=99    num=9   *10+9
		 * i=3 num=999   num=99  *10+9
		 * i=4 num=9999  num=999 *10+9
		 * i=5 num=99999 num=9999*10+9
		 */
		
		
		
		/*
		int i;
		for(i=0;i<10;i++){
		}
		System.out.println("i="+i); //i=10
		*/
		
		/*
		int i=0;
		while(i<10){
			i++;
		}
		System.out.println("i="+i); //i=10
		*/
		
	}
}
