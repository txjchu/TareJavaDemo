package day05;
//ð������
public class BubbleSort {
	public static void main(String[] args) {

		//1������int�����飬����10��Ԫ��
		//2.��10��Ԫ�ظ�ֵΪ0��99�������
		//3.���arr��ÿһ��Ԫ�ص�ֵ
		//4.��arrð������Ҫ������
		//5.�������������Ԫ��
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*100);
			System.out.println(arr[i]);
		}
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-1-j;j++){
			if(arr[j]>arr[j+1]){
				int max;
				max=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=max;
			
			}

	}
		}
		for (int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");	
		}
		
}
}

	