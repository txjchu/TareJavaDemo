package day05;

import java.util.Arrays;

public class MaxOfArray {

	public static void main(String[] args) {
		
		//7.���������
		int[] arr={100,34,2,36,86,4};
		
		
		/*
		int[] arr=new int[10];
		
		for (int i=0;i<arr.length;i++){          //-------��i=0��
			arr[i]=(int)(Math.random()*100);     //-------��ֵ1-100ֱ�������
			System.out.println(arr[i]);
		}

		int max=arr[0];//�����һ��Ԫ��Ϊ���ֵ
		for(int i=1;i<arr.length;i++){//����
			if(arr[i]>max){//��ʣ��Ԫ�ش���max
				max=arr[i];//�޸�maxΪ�ϴ��ֵ
			}
		}
		System.out.println("���ֵΪ��"+max);
		
		arr=Arrays.copyOf(arr,arr.length+1);//
		arr[arr.length-1]=max;//��max������������һλ
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		

		
		*/
		
		
		/*
		int[] arr=new int[10];
		
		for (int i=1;i<arr.length;i++){
			arr[i]=(int)(Math.random()*100);     //-------��ֵ1-100ֱ�������
			System.out.println(arr[i]);
		}

		int max=arr[0];//�����һ��Ԫ��Ϊ���ֵ
		for(int i=1;i<arr.length;i++){//����
			if(arr[i]>max){//��ʣ��Ԫ�ش���max
				max=arr[i];//�޸�maxΪ�ϴ��ֵ
			}
		}
		System.out.println("���ֵΪ��"+max);
		*/
	}

}
