package a02.day03;
//格子类
public class Cell {
	int row;
	int col;
	Cell(){
		this(0,0);
	}
	Cell(int n){
		this(n, n);
	}
	Cell(int row, int col){
		this.row = row;
		this.col = col;
	}
	void drop(){//下落1格
		row ++;
	}
	void drop(int n){//下落n格
		row +=n;
	}
	void moveLeft(){//左移1格
		col --;
	}
	void moveLeft(int n){//左移n格
		col -=n;
	}
	void moveRigth(){//右移1格
		col ++;
	}
	void moveRight(int n){//右移n格
		col +=n;
	}
	void getCellInfo(){//获取格子坐标
		System.out.print("("+ row +","+ col +")");
	}
}
