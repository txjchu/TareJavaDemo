package oo.day02;
//T型类
public class T {
	Cell[] cells;//格子数组
	T(){
		this(0,0);
	}
	T(int row,int col){
		this.cells=new Cell[4];//创建格子数组对象
		this.cells[0]=new Cell(row,col);//创建格子对象
		this.cells[1]=new Cell(row,col+1);
		this.cells[2]=new Cell(row,col+2);
		this.cells[3]=new Cell(row+1,col+1);
	}
	void drop(){//下落一格
		for(int i=0;i<cells.length;i++){
			cells[i].row++;
		}
	}
	void moveLeft(){//左移一格
		for(int i=0;i<cells.length;i++){
			cells[i].col--;
		}
	}
	void moveRight(){//右移一格
		for(int i=0;i<cells.length;i++){
			cells[i].col++;
		}
	}
	void print(){//输出格子行列号
		for(int i=0;i<cells.length;i++){
			String str=this.cells[i].getCellInfo();
			System.out.println(str);
		}
	}
}
