package a01;

import java.util.Arrays;
import java.util.Random;

/**
 * ð������
 * 1.����һ������Ϊ10���������
 * 2.��С�������򣬲��������
 * 3.������
 * @author Administrator
 *
 */
public class day05_c04_maopao {
	public static void main(String[] args) {
		//1.�����������
		int[] arr = new int[10];
		Random ran = new Random();
		for(int i = 0; i < arr.length; i++){
			arr[i] = ran.nextInt(100);
		}
		System.out.println(Arrays.toString(arr));//���ԭʼ����
		System.out.println("--------ð������ ��ʼ--------");
		//2.ð�����򣬲��������
		for(int i = 0; i < arr.length - 1; i ++){
			for(int j = 0; j < arr.length - 1 - i; j ++){
				if(arr[j] > arr[j + 1]){	//��	>�������У�<��������
					int max = arr[j];
					arr[j]= arr[j + 1];
					arr[j + 1] = max; 
				}
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("--------ð������ ����--------");
		System.out.println(Arrays.toString(arr));
	}
}
