package a01;

import java.util.Arrays;
import java.util.Random;

/**
 * �����������
 * 1.��װһ��generateArray()����������ָ�����ȣ�ָ����Χ��һ���������
 * 2.���÷����������
 */
public class day06_01_generateArray {
	public static void main(String[] args) {
		int[] a = generateArray(100,10);//���÷����������շ������ص�����
		System.out.println(Arrays.toString(a));//������
	}
	
	
	//1.��װ����
	public static int[] generateArray(int max, int length){ 
		int[] arr = new int[length];//����ָ�����ȵ�����
		for(int i = 0; i < arr.length; i++){
			Random ran = new Random();
			arr[i] = ran.nextInt(max); //���ɵ�����ָ����Χ��
						//(û��ȥ�ظ�)���磺[1, 7, 5, 0, 7, 5, 7, 4, 6, 4]
		}
		return arr; //�������շ�������
	}
	
}
