package day05;
import java.util.Arrays;
//�������ʾ
public class ArrayDemo {
	public static void main(String[] args) {
		/*
		 * �������ϰ:
		 * 1.����int������arr������4��Ԫ��
		 * 2.����int������arr1��ֱ�ӳ�ʼ��Ϊ1,3,5,7
		 *   ����int������arr2��new��ֱ�ӳ�ʼ��Ϊ1,3,5,7
		 * 3.���arr�ĳ���
		 *   ��arr�е�1��Ԫ�ظ�ֵΪ100
		 *   ���arr�е����һ��Ԫ�ص�ֵ(�±겻��д��)
		 *   arr[4]=200;----------???
		 * 4.������MaxOfArray����main()��:
		 *     ����int������arr������10��Ԫ��
		 *     ѭ����ʽ��arr�е�ÿ��Ԫ�ظ�ֵΪ0��99��������
		 *     ���arr��ÿ��Ԫ�ص�ֵ
		 */
		//7.���������
		int[] arr = {20,13,3,6,2,45,32,36,234,21};
		for(int i=0;i<arr.length-1;i++){ //������
			for(int j=0;j<arr.length-1-i;j++){ //����ÿ�ֱȵĴ���
				if(arr[j]>arr[j+1]){ //ÿ�ζ���������һ��Ԫ�ر�
					int t=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=t;
				}
			}
		}
		/*
		 * i=0
		 *   j=0 arr0��arr1
		 *   j=1 arr1��arr2
		 *   j=2 arr2��arr3
		 *   j=3
		 * i=1
		 *   j=0 arr0��arr1
		 *   j=1 arr1��arr2
		 *   j=2
		 * i=2
		 *   j=0 arr0��arr1
		 *   j=1
		 */
		
		
		
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		
		
		/*
		int[] arr = {100,34,2,36,86,4};
		Arrays.sort(arr); //��arr������
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		*/
		
		
		
		/*
		//6.����ĸ���
		int[] a = {10,20,30,40,50};
		//����һ�������飬ֻ�����ֽ�a(���������)
		a = Arrays.copyOf(a,a.length-1);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		*/
		
		/*
		int[] a = {10,20,30,40,50};
		//a:Դ����
		//a1:Ŀ������
		//6:Ŀ�������Ԫ�ظ���
		int[] a1 = Arrays.copyOf(a,6);
		for(int i=0;i<a1.length;i++){
			System.out.println(a1[i]);
		}
		*/
		
		
		/*
		int[] a = {10,20,30,40,50};
		int[] a1 = new int[6]; //0,0,0,0,0,0
		//a:Դ����
		//1:Դ�������ʼ�±�
		//a1:Ŀ������
		//0:Ŀ���������ʼ�±�
		//4:Ҫ���Ƶ�Ԫ�صĸ���
		System.arraycopy(a,1,a1,0,4);
		for(int i=0;i<a1.length;i++){
			System.out.println(a1[i]);
		}
		*/
		
		
		/*
		//5.����ı���
		int[] arr  = new int[10];
		for(int i=0;i<arr.length;i++){
			arr[i] = (int)(Math.random()*100);
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		*/
		
		
		
		/*
		//4.����ķ���
		int[] arr = new int[3];
		System.out.println(arr.length); //3
		System.out.println(arr[0]); //0
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;
		//arr[3] = 400; //�����±�Խ���쳣ArrayIndexOutOfBoundsException
		System.out.println(arr[arr.length-1]);
		*/
		
		/*
		//2.����ĳ�ʼ��
		int[] arr = new int[3];        //0,0,0
		int[] arr1 = {2,5,8};          //2,5,8
		int[] arr2 = new int[]{2,5,8}; //2,5,8
		int[] arr3;
		//arr3 = {2,5,8}; //������󣬴˷�ʽֻ������ͬʱ��ʼ��
		arr3 = new int[]{2,5,8}; //��ȷ
		*/
		
		/*
		//1.����Ķ���
		int[] arr = new int[4];
		*/
	}
}










