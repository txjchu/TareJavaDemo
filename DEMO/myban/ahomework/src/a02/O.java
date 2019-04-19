package a02;
//O类型
public class O {
	Cell[] cells;//创建1个格子数组
	O(){//无参构造
		this(0, 0);
	}
	O(int row, int col){
		cells = new Cell[4];//格子数组里有4个格子
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col+1);
		cells[2] = new Cell(row+1, col+1);
		cells[3] = new Cell(row+1, col);
	}
	void drop(){//下落1格的方法
		for(int i = 0; i < cells.length; i++){
			cells[i].row ++;//横坐标行加1表示下落1格
		}
	}
	void moveLeft(){//左移1格的方法
		for(int i = 0; i < cells.length; i++){
			cells[i].col --;//横坐标行不变，纵坐标列减1
		}
	}
	void moveRight(){//右移1格的方法
		for(int i = 0; i < cells.length; i ++){
			cells[i].col ++;//横坐标行不变，纵坐标列加1
		}
	}
	void print(){//打印每个格子的坐标
		String str = "";
		for(int i = 0; i < cells.length - 1; i++){
			str +=  cells[i].getCellInfo() ;
		}
		str +=  cells[cells.length - 1].getCellInfo();
		System.out.println(str);
	}
}
