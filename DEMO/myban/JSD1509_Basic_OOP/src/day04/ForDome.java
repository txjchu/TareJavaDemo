package day04;
//forѭ����ʾ
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
		//û��������ѭ��������ѭ��
		for(;;){
			System.out.println("��Ҫѧϰ");
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
			//ֻҪ��λ��Ϊ3��
			if(num%10!=3){
				sum += num;
			}
		}
		System.out.println("sum="+sum);
		*/
		
		/*
		int sum = 0; 
		for(int num=1;num<=100;num++){
			//������λΪ3��
			if(num%10==3){
				continue; //����ѭ������ʣ������������һ��ѭ��
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
		//�ۼӺ�: 1+2+3+4+...+100=?
		int sum = 0; //���
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
			System.out.println("�ж��ǳɹ��Ľ���");
		}
		System.out.println("over");
		*/
		/*
		 * ִ�й���:
		 * times=0 true ���
		 * times=1 true ���
		 * times=2 true ���
		 * times=3 true ���
		 * times=4 true ���
		 * times=5 true ���
		 * times=6 true ���
		 * times=7 true ���
		 * times=8 true ���
		 * times=9 true ���
		 * times=10 false forѭ������
		 * ���over
		 */		

	}

}
