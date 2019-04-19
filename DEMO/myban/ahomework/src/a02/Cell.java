package a02;
/**
 * day01_04_Cell
 * 格子类
 * @author Administrator
 *
 */
public class Cell {
	int row;//行
	int col;//列
	Cell(){//无参构造
		this(0,0);
	}
	Cell(int row){
		this(row,row);//方法中调用方法，调用Cell(int ,int)方法
	}
	Cell(int row, int col){//有参构造，参数名称和成员变量名称相同，则必须加this.
		this.row = row;//局部变量和成员变量同名时，this不能省略
		this.col = col;
	}
	Cell(Cell cell){//case练习03，可以用来测试将cell1赋值给cell2
		this(cell.row,cell.col);
	}
	void drop(){//向下移动1行
		row++;
	}
	void drop(int row){//重载drop()方法，
		this.row +=row;
	}
	void moveRight(){
		col++;//向右移动1列
	}
	void moveRight(int n){
		col += n;//向右移动n列
	}
	void moveLeft(){//向左移动
		col --;//向左移动1列
	}
	void moveLeft(int col){//重载moveLeft()方法，带上参数
		this.col -=col;
	}
	String getCellInfo(){//获取格子的行列号
		return "("+ row +","+ col +")";
	}
}
