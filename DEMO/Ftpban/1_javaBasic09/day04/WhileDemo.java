package day04;
//while��ʾ
public class WhileDemo {
	public static void main(String[] args) {
		/*
		 * ��ϰ:
		 * 1.���10��"�ж��ǳɹ��Ľ���"
		 * 2.��ӡ9�ĳ˷���
		 */
		
		int num = 1; //1.
		while(num<=9){ //2.
			System.out.println(num+"*9="+num*9);
			num++; //3.
		}
		System.out.println("over");
		
		
		
		
		/*
		int times=0;     //1.ѭ�������ĳ�ʼ��
		while(times<10){ //2.ѭ��������
			System.out.println("�ж��ǳɹ��Ľ���");
			times++;     //3.ѭ�������ĸı�
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
		 * tiems=10 false whileѭ������
		 * ���over
		 */
	}
}










