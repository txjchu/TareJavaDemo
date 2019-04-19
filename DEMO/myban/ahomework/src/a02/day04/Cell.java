package a02.day04;
//格子类
public class Cell {
	int row;//行
	int col;//列
	Cell(){//无参构造
		this(0, 0);
	}
	Cell(int n){
		this(n, n);
	}
	Cell(int row, int col){
		this.row = row;
		this.col = col;
	}
	void drop(){//下落1格的方法
		row ++;
	}
	void moveLeft(){//左移1格的方法
		col --;
	}
	void moveRight(){//右移1格的方法
		col ++;
	}
	void getCellInfo(){//获取格子的坐标
		System.out.print("("+ row +","+ col +")");
	}
}
