package oo.day04;
//J型类
public class J extends Tetromino{
	J(){
		this(0,0);
	}
	J(int row,int col){
		cells[0] = new Cell(row,col);
		cells[1] = new Cell(row,col+1);
		cells[2] = new Cell(row,col+2);
		cells[3] = new Cell(row+1,col+2);
	}
	void print(){ //输出格子行列号
		System.out.println("I am a J:");
		super.print(); //调用父类的super()方法
	}
}
