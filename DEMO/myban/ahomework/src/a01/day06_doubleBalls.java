package a01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * �Լ���˼·��
 * ˫ɫ��
 * 1.����˫ɫ�򷽷�
 * 2.���û�������������÷���
 * 3.���
 * @author Administrator
 *
 */
public class day06_doubleBalls {
	public static void main(String[] args) {
		//2.�����û�����ĸ���������˫ɫ�򷽷�
		Scanner scan = new Scanner(System.in);
		System.out.println("������˫ɫ�������0-9����");
		int nou = scan.nextInt();
		int[] balls = doubleBalls(nou);
		
		scan.close();
		//3.���
		System.out.println("����˫ɫ��Ϊ��"+ Arrays.toString(balls));
	}
	//1.����˫ɫ�򷽷�(���ܳ�����ͬ������)
	public static int[] doubleBalls(int n){
		int[] arr = new int[n];
		Random ran = new Random();
		for(int i = 0; i < arr.length; i++){
			arr[i] = ran.nextInt(10);//�������0 <= num < 10֮�����
			//ȥ���ظ�����
			for(int j = 0; j < i; j++){
				if(arr[i] == arr[j]){
					i --;//----���arr[i]��֮ǰĳ��Ԫ����ͬ����i-1,��������arr[i]
					continue;
				}				
			}
		}
		
		return arr;
	}
}
