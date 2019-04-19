package oo.day03;
//TJ的父类，四格拼版
public class Tetromino {//父类
//	Cell[][] cells = new Cell[4][];
	
	
	
	Cell[] cells;//格子数组
	Tetromino(){
		cells=new Cell[4];//创建格子数组对象------这是其无参构造方法，用于成员变量的初始化
	}
	
//	Tetromino te =new Tetromino();	//成员变量的定义，以及初始化
	
	
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
