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
public class day05_c01_zhishu1 {
	public static void main(String[] args) {
//		int num = 100;
		System.out.println("�����뷶Χ��2~");
		Scanner scan = new Scanner(System.in);
		int max = scan.nextInt();
		int count = 0;
		for(int j = 2; j <= max; j++){
			boolean isPrime = true;//�Ƿ�Ϊ����
			int m = (int) Math.sqrt(j);
			for(int i = 2; i <= m; i++){//1.�ж��Ƿ�Ϊ������ƽ��������,i����<=m
				if(j % i == 0){
					isPrime = false;
//					System.out.print(isPrime);
					break;
				}
			}		
			if(isPrime){//3.���
				count ++;
				System.out.print(j +" ");	
				while(count % 10 == 0){
					System.out.println();
				}
			}
		}
		scan.close();
		System.out.println("\r"+"��Χ�ڹ���"+ count +"������");
	}
}
