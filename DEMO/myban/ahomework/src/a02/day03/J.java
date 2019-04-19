package a02.day03;
//J类型格子（继承Tetromino）
public class J extends Tetromino{
	J(){
		this(0, 0);
	}
	J(int row, int col){
		super();
//		cells = new Cell[4];
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col+1);
		cells[2] = new Cell(row, col+2);
		cells[3] = new Cell(row+1, col+2);
	}
}
	/*
	Cell[] cells;//创建1个格子数组
	J(){//无参构造
		this(0, 0);
	}
	J(int n){
		this(n , n);
	}
	J(int row, int col){//有参构造
		cells = new Cell[4];//格子数组中有4个元素格子
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col+1);
		cells[2] = new Cell(row, col+2);
		cells[3] = new Cell(row+1, col+2);
	}
	void drop(){//下落1格
		for(int i = 0; i < cells.length; i++){
			cells[i].row ++;
		}
	}
	void drop(int n){//下落n格
		for(int i = 0; i < cells.length; i++){
			cells[i].row +=n;
		}
	}
	void moveLeft(){//左移1格
		for(int i = 0; i < cells.length; i++){
			cells[i].col --;
		}
	}
	void moveLeft(int n){//左移n格
		for(int i = 0; i < cells.length; i++){
			cells[i].col -=n;
		}
	}
	void moveRight(){//右移1格
		for(int i = 0; i < cells.length; i++){
			cells[i].col ++;
		}
	}
	void moveRight(int n ){//右移n格
		for(int i = 0; i < cells.length; i++){
			cells[i].col +=n;
		}
	}
	void print(){//打印所有格子元素的坐标
		for(int i = 0; i < cells.length; i++){
			cells[i].getCellInfo();
		}
		System.out.println();
	}
*/
