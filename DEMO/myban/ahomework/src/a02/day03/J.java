package a02.day03;
//J���͸��ӣ��̳�Tetromino��
public class J extends Tetromino{
	J(){
		this(0, 0);
	}
	J(int row, int col){
		super();
//		cells = new Cell[4];
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col+1);
		cells[2] = new Cell(row, col+2);
		cells[3] = new Cell(row+1, col+2);
	}
}
	/*
	Cell[] cells;//����1����������
	J(){//�޲ι���
		this(0, 0);
	}
	J(int n){
		this(n , n);
	}
	J(int row, int col){//�вι���
		cells = new Cell[4];//������������4��Ԫ�ظ���
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col+1);
		cells[2] = new Cell(row, col+2);
		cells[3] = new Cell(row+1, col+2);
	}
	void drop(){//����1��
		for(int i = 0; i < cells.length; i++){
			cells[i].row ++;
		}
	}
	void drop(int n){//����n��
		for(int i = 0; i < cells.length; i++){
			cells[i].row +=n;
		}
	}
	void moveLeft(){//����1��
		for(int i = 0; i < cells.length; i++){
			cells[i].col --;
		}
	}
	void moveLeft(int n){//����n��
		for(int i = 0; i < cells.length; i++){
			cells[i].col -=n;
		}
	}
	void moveRight(){//����1��
		for(int i = 0; i < cells.length; i++){
			cells[i].col ++;
		}
	}
	void moveRight(int n ){//����n��
		for(int i = 0; i < cells.length; i++){
			cells[i].col +=n;
		}
	}
	void print(){//��ӡ���и���Ԫ�ص�����
		for(int i = 0; i < cells.length; i++){
			cells[i].getCellInfo();
		}
		System.out.println();
	}
*/
