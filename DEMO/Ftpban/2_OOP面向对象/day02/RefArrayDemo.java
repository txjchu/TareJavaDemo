package oo.day02;
//引用类型数组演示
public class RefArrayDemo {
	public static void main(String[] args) {
		/*
		//1.
		Cell[] cells = new Cell[4];
		cells[0] = new Cell(1,2);
		cells[1] = new Cell(2,3);
		cells[2] = new Cell(3,4);
		cells[3] = new Cell(4,5);
		*/
		
		/*
		//2.
		Cell[] cells = new Cell[]{
			new Cell(1,2),
			new Cell(2,3),
			new Cell(3,4),
			new Cell(4,5)
		};
		*/
		
		/*
		//3.
		int[][] arr = new int[3][];
		arr[0] = new int[2];
		arr[1] = new int[3];
		arr[2] = new int[2];
		arr[1][0] = 100;
		*/
		
		//4.
		int[][] arr = new int[3][4];
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				arr[i][j] = 100;
			}
		}
	}
}













