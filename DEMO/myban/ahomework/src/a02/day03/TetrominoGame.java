package a02.day03;

public class TetrominoGame {
	public static void main(String[] args) {
		Tetromino t = new T(2,2);
		t.print();
		printTetromino(t);
		t.drop();
		t.print();
		printTetromino(t);
		Tetromino j = new J(3,4);
		j.print();
		printTetromino(j);
		j.drop();
		j.print();
		printTetromino1(j);
//		T t1 = new T(3,3);
//		t.print();
////		t1.drop();
//		t1.moveLeft();
//		t.print();
	}
	public static void printTetromino1(Tetromino tetromino){
		Cell[] cells = tetromino.cells;
		int totalrow = 10;
		int totalcol = 20;
		for(int row = 0; row < totalrow; row++){
			for(int col = 0; col < totalcol; col++){
				boolean flag = true;//用来对每一个格子做个判断标记
				for(int i = 0; i < cells.length; i++){
					if(row == cells[i].row && col == cells[i].col){
						flag = false;
						break;
					}
				}
				if(flag){
					System.out.print("-");
				}else{
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
	public static void printTetromino(Tetromino tetromino){//打印格子的方法
		Cell[] cells = tetromino.cells;//接收到方块的所有格子
		int totalrow = 10;
		int totalcol = 20;
		for(int i = 0; i < totalrow; i++ ){
			for(int j = 0; j < totalcol; j++){
				if((i == cells[0].row && j == cells[0].col)
						|| (i == cells[1].row && j == cells[1].col)
						|| (i == cells[2].row && j == cells[2].col)
						|| (i == cells[3].row && j == cells[3].col)){
					System.out.print("*");
				}else{
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
}