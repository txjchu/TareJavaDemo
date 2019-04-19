package day05;

public class maopaowenda {

	public static void main(String[] args) {
		/*
		int[] arr=new int[6];
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*100);
			System.out.print(arr[i]+"\t");
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
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");
*/
		int[] arr=new int[9];
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*100);
			System.out.print(arr[i]+" ");			
	}
		for(int i=0;i<arr.length;i++){
			
			int min=arr[i];
			if(min>arr[i]){
				min=arr[i];
			}
			System.out.println("最小值为："+min);
		}
}
}