package a02;
//T型
public class T {
	Cell[] cells;//创建1个格子数组
	T(){//无参构造
		this(0,0);
	}
	T(int row, int col){
		cells = new Cell[4];
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col + 1);
		cells[2] = new Cell(row, col + 2);
		cells[3] = new Cell(row + 1, col + 1);
	}
	void drop(){//T下落一格的方法
		for(int i = 0; i < cells.length; i++){
			cells[i].row ++;
		}
	}
	void moveLeft(){//T左移1格的方法
		for(int i = 0; i < cells.length; i++){
			cells[i].col --;
		}
	}
	void moveRight(){//T右移1格的方法
		for(int i = 0; i < cells.length; i++){
			cells[i].col ++;
		}
	}
	void print(){//输出T的四个格子的坐标
		for(int i = 0; i < cells.length; i++){
			String str = cells[i].getCellInfo();
			System.out.print(str);
		}
		System.out.println();
	}
}
