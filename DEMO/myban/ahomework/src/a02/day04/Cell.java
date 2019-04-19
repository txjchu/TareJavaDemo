package a02.day04;
//������
public class Cell {
	int row;//��
	int col;//��
	Cell(){//�޲ι���
		this(0, 0);
	}
	Cell(int n){
		this(n, n);
	}
	Cell(int row, int col){
		this.row = row;
		this.col = col;
	}
	void drop(){//����1��ķ���
		row ++;
	}
	void moveLeft(){//����1��ķ���
		col --;
	}
	void moveRight(){//����1��ķ���
		col ++;
	}
	void getCellInfo(){//��ȡ���ӵ�����
		System.out.print("("+ row +","+ col +")");
	}
}
