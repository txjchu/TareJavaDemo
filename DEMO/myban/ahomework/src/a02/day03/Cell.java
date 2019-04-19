package a02.day03;
//������
public class Cell {
	int row;
	int col;
	Cell(){
		this(0,0);
	}
	Cell(int n){
		this(n, n);
	}
	Cell(int row, int col){
		this.row = row;
		this.col = col;
	}
	void drop(){//����1��
		row ++;
	}
	void drop(int n){//����n��
		row +=n;
	}
	void moveLeft(){//����1��
		col --;
	}
	void moveLeft(int n){//����n��
		col -=n;
	}
	void moveRigth(){//����1��
		col ++;
	}
	void moveRight(int n){//����n��
		col +=n;
	}
	void getCellInfo(){//��ȡ��������
		System.out.print("("+ row +","+ col +")");
	}
}
