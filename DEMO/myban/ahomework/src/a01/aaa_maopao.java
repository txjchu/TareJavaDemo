package a01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * ð���㷨
 * 1.�Զ���������
 * 2.ð�����򣨲�������̣�
 * 3.������ս��
 * @author Administrator
 *
 */
public class aaa_maopao {
	public static void main(String[] args) {
		//1.�Զ���������
		Scanner scan = new Scanner(System.in);
		System.out.println("�����������Ԫ��������0~100����");
		int count = scan.nextInt();//�����Ԫ�ظ���
		System.out.println("���������ֵ����Χ��0~1000����");
		int max = scan.nextInt();//����Ԫ�ص����Χ
		int[] arr = new int[count];//�洢�Զ����ɵ�����
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * max);
		}
		System.out.println(Arrays.toString(arr));//���ԭ����
		//2.����
		System.out.println("----------ð������ʼ----------");
		for(int i = 0; i < arr.length - 1; i++){
			for(int j = 0; j < arr.length - 1 - i; j++){
				if(arr[j + 1] < arr[j]){
					int num = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = num;
				}
			}
			System.out.println(Arrays.toString(arr));	
		}
		//3.������ս��
		int[] arrNew = Arrays.copyOf(arr, arr.length + 1);
		arrNew[arrNew.length - 1] = arr[arr.length - 1];
		System.out.println("----------ð���������----------");
		System.out.println(Arrays.toString(arrNew));//������ս��
		scan.close();
	}
//	�������е����ֵ
//	public static void main(String[] args) {
//		int[] arr = new int[10];
//		for(int i = 0; i < arr.length; i++){
//			Random ran = new Random();
//			arr[i] = ran.nextInt(100);
//			System.out.print(arr[i]+ " ");
//		}
//		System.out.println();
//		int max = 0 ;
//		for(int i = 0; i < arr.length ; i++){
//			if(max < arr[i]){
//				max = arr[i];
//			}
//		}
//		System.out.print(max);
//	}
}
