package day02;

import java.util.Arrays;
import java.util.Random;

/**
 * �����⣺
 * ��һ���߶�10��̨�׵�¥�ݣ����������ߣ�ÿ��һ��ֻ������1����2��̨�ס�
 * Ҫ���ó��������һ���ж������߷�
 * @author Administrator
 *
 */
public class stepDemo {	
	
	//2.ʹ��ѭ�����
	public int kids(int step){
		int[] arr = new int[]{1, 2};
		if(step == 1){return 1;}
		if(step == 2){return 2;}
		for(int i = 3; i <= step; i ++){
			int n = arr[1];
			arr[1] = arr[1] + arr[0];
			arr[0] = n;
		}
		return arr[1];
	}
	//3.ʹ�õݹ�
	public int count(int step){
		if(step == 1){
			return 1;
		}else if(step == 2){
			return 2;
		}else {
			return count(step - 1) + count(step - 2);
		}
	}
	
	
	
	public static void main(String[] args) {
		/*
		 *  n��̨������1  2  3  4  5   6   7   8   9   10  ....
		 * m���߲�������1  2  3  5  8  13  21  34  55   89  .... 
		 * ����10��̨�׵��߲�����Ϊ89�֡���Ϊÿһ���Ĳ���Ϊ1��2��
		 * 쳲������������n���ֵ
		 */
		
		stepDemo s = new stepDemo();
		//2.����forѭ���ķ���
		int count = s.kids(10);
		System.out.println(count);
		//3.���õݹ�ķ���
		count = s.count(45);//  ========������ʱ��
		System.out.println(count);
		
	//1.ʹ��������ȱ�㣺��Ҫ��������һ�������ڴ�ռ俪֧��	
	int index = 10;	//int���͵����̨����Ϊ45��1836311903��
	count = 0;
	int[] fibonacci = new int[3];//쳲���������
	fibonacci[0] = 1;
	fibonacci[1] = 1 + fibonacci[0];
	fibonacci[2] = fibonacci[2 - 1] + fibonacci[2 - 2];
	for(int i = 3; i < index; i ++){
		fibonacci = Arrays.copyOf(fibonacci, fibonacci.length + 1);
		fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
	}
	//��n��̨�������߲���ʽΪfibonacci[n-1]��
	count = fibonacci[index - 1];	
	System.out.println(count);
		
		
		
		
/*		
/**
 * ˼·���ԣ������������������̱�̵�˼·��		
 *-/
		
		int[] arr = new int[1];//���ڴ洢ÿһ���߷�
		int steeps = 10;//�ܹ���10��̨��
		int sum = 0;//����һ���߷��е�ǰ��Խ�˶��ټ�
		int index = 0;//ÿһ�����±�
		do{
			Random ran = new Random();
			if(sum < steeps + 1){//���sumС��11
				arr[arr.length - 1] = ran.nextInt(2) + 1;//�������ÿһ������ļ���
				sum += arr[arr.length - 1];//�Ѿ����˶��ټ�̨��
				
				//��steeps < sum < steeps + 1ʱ������arr���ݣ�
				
				arr = Arrays.copyOf(arr, arr.length + 1);
				
			}else{//���sum����11
				arr = Arrays.copyOf(arr, arr.length - 1);//���ݣ�ɾ�����һ��
				arr[arr.length - 2] = ran.nextInt(2) + 1;
				sum += arr[arr.length - 2];
			}
			System.out.println(Arrays.toString(arr));
			
			
		}while(sum < steeps || (sum == 11 && arr[index - 2] == 2));
/**
 * 1.��β��ϵĽ��µ�arr���뵽arrs��
 * 2.��β��ϵĲ����µ�arr(arr������̨������10�������ɣ���ν�����һ��arr������)
 * 
 * 
 *-/
		//��arr����arrs�С�
		int[][] arrs = new int[1][];
		//�ж�arr�Ƿ������arrs��
		boolean flag = false;
		for(int i = 0; i < arrs.length; i ++){
			if(arr.equals(arrs[i])){
				flag = true;
			}
		}
		
		//���û�а�����arrs�У������arrs�С�����arrs.length�������ս�����������߷���
		if(flag == false ){
			arrs[arrs.length - 1] = arr ;//����Ԫ�ط�����������һλ��
			arrs = Arrays.copyOf(arrs, arrs.length + 1);//���������ݣ�׼��������һ����arr
		}
		
		//�����ܹ��ж������߷�
		int count = 0;//���ڴ����ܹ��������߷���
		if(arrs[arrs.length - 1] == null){//���arrs���������ȴû����arr���룬�����һλԪ��Ϊnull
			count = arrs.length - 1;
		}else{
			count = arrs.length;
		}
		System.out.println("һ����"+ count +"���߷���");
		for(int i = 0; i < arrs.length ; i++){
			System.out.println(Arrays.toString(arrs[i]));
			
		}
*/		
	}
}














