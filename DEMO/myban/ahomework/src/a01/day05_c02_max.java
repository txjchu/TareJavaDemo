package a01;

import java.util.Arrays;
import java.util.Random;

/**
 * �������������
 * @author Administrator
 *
 */
public class day05_c02_max {
	public static void main(String[] args) {
		int[] arr = new int[10];//����һ������Ϊ10������
		int max = 0;
		//�������10��0~99֮������֣���������
		Random ran = new Random();
		for(int i = 0; i < arr.length; i++){
//			arr[i] = (int) (Math.random()*100);
			arr[i] = ran.nextInt(100);
			if(max < arr[i]){//��������������ֵ
				max = arr[i];
			}
		}
		//������飬������ֵ
		System.out.println(Arrays.toString(arr));
		System.out.println("���������ֵΪ��"+ max);
	}
}
