package day04;

public class WhileDemo {
//while��ʾ
	public static void main(String[] args) {
		
		/*
		//����2
		//���9�ĳ˷���
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
		int sum=0;//���
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
		 * ִ�й��̣�
		 * num=1  true  ���
		 * num=2  true  ���
		 * num=3  true  ���
		 * num=4  true  ���
		 * num=5  true  ���
		 * num=6  true  ���
		 * num=7  true  ���
		 * num=8  true  ���
		 * num=9  true  ���
		 * num=10  false  whileѭ������
		 * ���over
		 */
		
		
		
		/*
		 //����1
		 int times=0;  //1.ѭ�������ĳ�ʼ��
		 
		while (times<10){//2.ѭ��������
			System.out.println("�ж��ǳɹ��ĵ�һҪ��");	
			times++;     //3.ѭ�������ĸı�
		}
		System.out.println("over");
		/*
		 * ִ�й��̣�
		 * times=0  true  ���
		 * times=1  true  ���
		 * times=2  true  ���
		 * times=3  true  ���
		 * times=4  true  ���
		 * times=5  true  ���
		 * times=6  true  ���
		 * times=7  true  ���
		 * times=8  true  ���
		 * times=9  true  ���
		 * times=10 false  whileѭ������
		 * ���over
		 */
	}

}
