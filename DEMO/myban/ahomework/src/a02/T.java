package a02;
//T��
public class T {
	Cell[] cells;//����1����������
	T(){//�޲ι���
		this(0,0);
	}
	T(int row, int col){
		cells = new Cell[4];
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col + 1);
		cells[2] = new Cell(row, col + 2);
		cells[3] = new Cell(row + 1, col + 1);
	}
	void drop(){//T����һ��ķ���
		for(int i = 0; i < cells.length; i++){
			cells[i].row ++;
		}
	}
	void moveLeft(){//T����1��ķ���
		for(int i = 0; i < cells.length; i++){
			cells[i].col --;
		}
	}
	void moveRight(){//T����1��ķ���
		for(int i = 0; i < cells.length; i++){
			cells[i].col ++;
		}
	}
	void print(){//���T���ĸ����ӵ�����
		for(int i = 0; i < cells.length; i++){
			String str = cells[i].getCellInfo();
			System.out.print(str);
		}
		System.out.println();
	}
}
