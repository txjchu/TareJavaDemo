package a02.day04;
//方块类
public class Tetromino {
	Cell[] cells;//成员变量
	Tetromino(){//构造函数
		cells = new Cell[4];
	}
	void drop(){//方块下落1格的方法
		for(int i = 0; i < cells.length; i++){
			cells[i].drop();
		}
	}

	void moveLeft(){//方块左移1格的方法
		for(int i = 0; i < cells.length; i++){
			cells[i].moveLeft();
		}
	}
	void moveRight(){//方块右移1格的方法
		for(int i = 0; i < cells.length; i++){
			cells[i].moveRight();
		}
	}
	void print(){//打印方块坐标的方法
		for(int i = 0; i < cells.length; i++){
			cells[i].getCellInfo();
		}
		System.out.println();
	}
}
