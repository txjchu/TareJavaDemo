package a02.day04;
//������
public class Tetromino {
	Cell[] cells;//��Ա����
	Tetromino(){//���캯��
		cells = new Cell[4];
	}
	void drop(){//��������1��ķ���
		for(int i = 0; i < cells.length; i++){
			cells[i].drop();
		}
	}

	void moveLeft(){//��������1��ķ���
		for(int i = 0; i < cells.length; i++){
			cells[i].moveLeft();
		}
	}
	void moveRight(){//��������1��ķ���
		for(int i = 0; i < cells.length; i++){
			cells[i].moveRight();
		}
	}
	void print(){//��ӡ��������ķ���
		for(int i = 0; i < cells.length; i++){
			cells[i].getCellInfo();
		}
		System.out.println();
	}
}
