package a02.day03;
//T类型格子（继承Tetromino）
public class T extends Tetromino{
	T(){//无参构造
		this(0, 0);
	}
	T(int row, int col){
		super();
//		cells = new Cell[4];
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col+1);
		cells[2] = new Cell(row, col+2);
		cells[3] = new Cell(row+1, col+1);
	}
/*	
	T(){
		this(0, 0);
	}
	T(int row){
		this(row, row);
	}
	T(int row, int col){
		cells = new Cell[4];
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col+1);
		cells[2] = new Cell(row, col+2);
		cells[3] = new Cell(row+1, col+1);
	}
	void drop(){//T类下落1格
		for(int i = 0; i < cells.length; i++){
			cells[i].row ++;
		}
	}
	void drop(int n){//T类下落n格
		for(int i = 0; i < cells.length; i++){
			cells[i].row +=n;
		}
	}
	void moveLeft(){//T类左移1格
		for(int i = 0; i < cells.length; i++){
			cells[i].col --;
		}
	}
	void moveLeft(int n){//T类左移n格
		for(int i = 0; i < cells.length; i++){
			cells[i].col -=n;
		}
	}
	void moveRight(){//T类右移1格
		for(int i = 0; i < cells.length; i++){
			cells[i].col ++;
		}
	}
	void moveRight(int n){//T类右移n格
		for(int i = 0; i < cells.length; i++){
			cells[i].col +=n;
		}
	}
	void print(){//打印T类型的所有格子的坐标
		for(int i = 0; i < cells.length; i++){
			cells[i].getCellInfo();
		}
		System.out.println();
	}
*/	
}
