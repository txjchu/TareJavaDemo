package a01;

import java.util.Arrays;
import java.util.Random;

/**
 * �ҳ�һ�������е����ֵ�����ŵ����ݺ����������һ��λ��
 * 1.����1������Ϊ10�����������
 * 2.�ҳ����������ֵ
 * 3.�������飬�������ֵ�������һλ
 * 4.���
 * @author Administrator
 *
 */
public class day05_c03_max {
	public static void main(String[] args) {
		//1.��������
		int[] arr = new int[10];
		Random ran = new Random();
		for(int i = 0; i < arr.length; i++){
			arr[i] = ran.nextInt(100);
		}
		System.out.println("��������Ϊ��"+ Arrays.toString(arr));
		//2.�ҳ����ֵ
		int max = arr[0]; //�����ֵ��ʼ��Ϊ�����еĵ�һ��Ԫ��
		for(int i = 1; i < arr.length; i++){
			if(max < arr[i]){
				max = arr[i];
			}
		}
		System.out.println("���������ֵΪ��"+ max);
		//3.���������飬���������ֵ
//		arr = Arrays.copyOf(arr, arr.length + 1); 	Arrays.copyOf()��Ӧ��
		int[] arrNew = new int[arr.length + 1];
		System.arraycopy(arr, 0, arrNew, 0, arr.length);
		arrNew[arrNew.length - 1] = max;
		//���
		System.out.println("������Ϊ��"+ Arrays.toString(arrNew));
	}
}
