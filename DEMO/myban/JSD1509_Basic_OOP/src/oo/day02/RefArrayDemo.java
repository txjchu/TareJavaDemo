package oo.day02;
//引用类型数组演示
public class RefArrayDemo {
	public static void main(String[] args) {
	
	
	/*
	Cell[] cells=new Cell[4];
	cells[0]=new Cell();
	cells[1]=new Cell();
	cells[2]=new Cell();
	cells[3]=new Cell();
	*/
	
	Cell[] cells={
			new Cell(),
			new Cell(),
			new Cell()
	};
	
	int[][] arr=new int[3][];
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				arr[i][j]=100;
			}
		}
	int[][] arr1 = new int[3][5];
	for(int i = 0; i < arr1.length; i ++){
		for(int j = 0; j < arr[i].length; j++){
			arr[i][j] = 100;//将每一个元素赋值
		}
	}
	
	/*
	int[][] arr={
		arr[0]=new arr[2],
		new arr[3],
		new arr[2]
	};
*/
	}

}
