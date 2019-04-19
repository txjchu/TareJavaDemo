package a02.day04;
//T类方块
public class T extends Tetromino{
	T(){//无参构造
		this(0,0);
	}
	T(int row, int col){
		super();
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col+1);
		cells[2] = new Cell(row, col+2);
		cells[3] = new Cell(row+1, col+1);
	}
	void print(){
		System.out.println("i am a T");
		super.print();
		
	}
}
