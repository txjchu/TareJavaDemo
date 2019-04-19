package day05;
//冒泡排序
public class B01 {
	public static void main(String[] args) {
		//1)声明int型数组arr，包含10个元素
		//2)将10个元素赋值为0到99的随机数
		//3)输出arr中每个元素的值
		//4)对arr冒泡排序---升序
		//5)输出排序后的数组元素
	int[] arr=new int[10];
	for(int i=0;i<arr.length;i++){
		arr[i]=(int)(Math.random()*100);
		System.out.println(arr[i]);
	}
	for(int i=0;i<arr.length-1;i++){
		for(int j=0;j<arr.length-1-i;j++){
			if(arr[j]>arr[j+1]){
				int max=arr[j];
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






