package a02.day03;
//T���͸��ӣ��̳�Tetromino��
public class T extends Tetromino{
	T(){//�޲ι���
		this(0, 0);
	}
	T(int row, int col){
		super();
//		cells = new Cell[4];
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col+1);
		cells[2] = new Cell(row, col+2);
		cells[3] = new Cell(row+1, col+1);
	}
/*	
	T(){
		this(0, 0);
	}
	T(int row){
		this(row, row);
	}
	T(int row, int col){
		cells = new Cell[4];
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col+1);
		cells[2] = new Cell(row, col+2);
		cells[3] = new Cell(row+1, col+1);
	}
	void drop(){//T������1��
		for(int i = 0; i < cells.length; i++){
			cells[i].row ++;
		}
	}
	void drop(int n){//T������n��
		for(int i = 0; i < cells.length; i++){
			cells[i].row +=n;
		}
	}
	void moveLeft(){//T������1��
		for(int i = 0; i < cells.length; i++){
			cells[i].col --;
		}
	}
	void moveLeft(int n){//T������n��
		for(int i = 0; i < cells.length; i++){
			cells[i].col -=n;
		}
	}
	void moveRight(){//T������1��
		for(int i = 0; i < cells.length; i++){
			cells[i].col ++;
		}
	}
	void moveRight(int n){//T������n��
		for(int i = 0; i < cells.length; i++){
			cells[i].col +=n;
		}
	}
	void print(){//��ӡT���͵����и��ӵ�����
		for(int i = 0; i < cells.length; i++){
			cells[i].getCellInfo();
		}
		System.out.println();
	}
*/	
}
