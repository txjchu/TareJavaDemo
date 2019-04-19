package oo.day02;
//格子类
public class Cell {
	
	int row;//行号
	int col;//列号
	Cell c=new Cell();
	
	Cell(){
		this(0,0);
	}
	Cell(int n){
		this(n,n);
	}
	Cell(int row,int col){
		this.row=row;
		this.col=col;
		
	}
	void drop(){	//下降1格
		row++;		//行号增加1
	}
	void moveLeft(int n){ //左移n格
		col-=n; //列号减n
	}
	String getCellInfo(){ //获取格子行号和列号
		return row+","+col; //返回行列号
	}

	void drop(int n){ //下落n格
		row+=n;
	}
	void moveLeft(){ //左移1格
		col--;
	}
	
	/*
	int row;//行号
	int col;//列号
	
	void drop(){//下落1格
		row++;//行号增1
	}
	void moveLeft(int n){  //左移n格
		col-=n;//列号减n
	}
	void moveRight(int n){  //右移n格
		col+=n;//列号加n
	}
	void drop(int n){
		row+=n;
	}
	void moveLeft(){
		col--;
	}
	String getCellInfo(){//获取格子行号和列号
		return row+","+col;//返回行列号
	}
	*/
}
