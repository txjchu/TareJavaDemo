package day05;
import java.util.Arrays;
//�������ʾ
public class ArrayDemo {
	public static void main(String[] args) {
		/*
		 * �������ϵ��
		 * 1.����int������arr,����4��Ԫ��
		 * 2.����int������arr1,ֱ�ӳ�ʼ��Ϊ1��3��5��7
		 *   ����int������arr2,new��ֱ�ӳ�ʼ��Ϊ1��3��5��7
		 * 3.���arr�ĳ��� 
		 *   ��arr�е�1��Ԫ�ظ�ֵΪ100
		 *   ���arr�е����һ��Ԫ�ص�ֵ(�±겻��д��)
		 *   arr[4]=200;----------???
		 * 4.������MaxOfArray����main()��:
		 *   ����int������arr������10��Ԫ��
		 *   ѭ����ʽ��arr�е�ÿ��Ԫ�ظ�ֵΪ0��99��������
		 *   ���arr��ÿ��Ԫ�ص�ֵ
		 *   
		 */
		
		int[] arr=new int[4];
		int[] arr1={1,3,5,7};
		int[] arr2=new int[]{1,3,5,7};
		System.out.println(arr[arr.length]);
		
		arr[0]=100;
		System.out.println(arr[arr.length-1]);
	
		//arr[4]=200;
		
		// 6.����ĸ���
		int[] a={10,20,30,40,50};
		int[] a1=new int[6];//0,0,0,0,0,0
		//a:Դ����
		//1:Դ�������ʼ�±�
		//a1:Ŀ������
		//0:Ŀ���������ʼ�±�
		//4:Ҫ���Ƶ�Ԫ�صĸ���
		System.arraycopy(a,1,a1,0,4);
		for(int i=0;i<a1.length;i++){
			System.out.println(a1[i]);
		}
		
		
		/*
		//5.����ı���
		int[] arr=new int[10];
		
		*/
		
		/*
		//4.����ķ���
		System.out.println(arr.length);//3
		System.out.println(arr[0]);//0
		arr[0]=100;
		arr[1]=200;
		arr[2]=300;
		arr[3]=400;//-----����
		arr[arr.length-1]=
		*/
		
		/*
		//2.����ĳ�ʼ��
		int[] arr=new int[3];
		int[] arr1={2,5,8};
		int[] arr2=new int[]{2,5,8};
		int[] arr3;
		//arr3=
		int[] arr4=
		*/
		/*
		//1.����Ķ���
		int[] arr=new int[4];
		*/
		
	}

}
