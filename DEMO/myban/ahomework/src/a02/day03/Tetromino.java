package a02.day03;
//方块类
public class Tetromino {
	Cell[] cells;//创建1个格仔数组
	Tetromino(){//构造函数
		cells = new Cell[4];
	}
	void print(){//打印方块中所有格子的坐标
		for(int i = 0; i < cells.length; i ++){
			cells[i].getCellInfo();
		}
		System.out.println();
	}
	void drop(){//下落1格
		for(int i = 0; i < cells.length; i++){
			cells[i].row ++;
		}
	}
	void moveLeft(){//左移1格
		for(int i = 0; i < cells.length; i++){
			cells[i].col --;
		}
	}
	void moveRight(){//右移1格
		for(int i = 0; i < cells.length; i++){
			cells[i].col ++;
		}
	}
}
