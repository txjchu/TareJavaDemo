package a01;

import java.util.Scanner;

/**
 * �ý�����ʽ�����һ����Χ�ڵ���������
 * 1.�ж��Ƿ�Ϊ����
 * 2.�����û�����ķ�Χ
 * 3.������
 * @author Administrator
 *
 */
public class day05_c01_zhishu {
	public static void main(String[] args) {
		System.out.println("�����뷶Χ2~" );
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();//2.�����û�����ķ�Χ
		System.out.println(num);
		int count = 0;
		for(int j = 2; j <= num; j++){		//�жϷ�Χ�ڵ�ÿһ����
			boolean isPrime = true;
			for(int i = 2; i < j/2; i++){//1.�ж�ĳ�����Ƿ�Ϊ������2�ַ���
				if(j % i == 0){
					//��������
					isPrime = false;
					break;
				}
			}		
			if(isPrime){					
				//������
				count ++;
				System.out.print(" "+ j);//3.�����������
					while(count % 10 == 0){
						System.out.println();
						break;
					}
			}
	}
		scan.close();
		System.out.println("��Χ�ڹ���"+ count +"������");
	}
}
