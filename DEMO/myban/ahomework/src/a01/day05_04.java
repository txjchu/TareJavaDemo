package a01;

import java.util.Arrays;

/**
 * ��ѯ��������С����������Ϊ������
 * 1.��������arr[]
 * 2.�ҳ���������С��
 * 3.���������飬������С����arr[]���
 * @author Administrator
 *
 */
public class day05_04 {
	public static void main(String[] args) {
		int[] arr = new int[10];//1.����arr[]���飬ÿ������Ԫ���������
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int) (Math.random()* 100);
		}
		System.out.println("�����е�����Ϊ��"+ Arrays.toString(arr));
		int min = arr[0];
		for(int i = 1; i < arr.length; i++){
			if(min > arr[i]){
				min = arr[i];
			}
		}
		System.out.println("��������С��Ϊ��"+ min);
//		for(int j = 0; j < arr.length-1; j++){
//			for(int i = arr.length - 1; i > 0; i--){//2.������������С��
//				if(arr[i] < arr[i-1]){
//					int min ;
//					min = arr[i-1];
//					arr[i-1] = arr[i];
//					arr[i] = min;
//				}
//			}
//		}
		int[] arrNew = new int[arr.length + 1];//3.����������,--ע��˴�������ĳ���
		System.arraycopy(arr, 0, arrNew, 1, arr.length);
		arrNew[0] = min;
		System.out.println("�������е�����Ϊ��"+ Arrays.toString(arrNew));
//		for(int i = 0; i < arrNew.length; i++){
//			System.out.print(arrNew[i] +" ");
//		}
	}
}
