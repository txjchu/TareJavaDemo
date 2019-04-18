package oo.day03;
//四格拼板
public class Tetromino { //父类
	Cell[] cells; //格子数组
	Tetromino(){
		cells = new Cell[4]; //创建格子数组对象
	}

	void drop(){ //下落一格
		for(int i=0;i<this.cells.length;i++){
			this.cells[i].row++;
		}
	}
	void moveLeft(){ //左移一格
		for(int i=0;i<cells.length;i++){
			cells[i].col--;
		}
	}
	void moveRight(){ //右移一格
		for(int i=0;i<cells.length;i++){
			cells[i].col++;
		}
	}
	void print(){ //输出格子行列号
		for(int i=0;i<this.cells.length;i++){
			String str = this.cells[i].getCellInfo();
			System.out.println(str);
		}
	}
}













