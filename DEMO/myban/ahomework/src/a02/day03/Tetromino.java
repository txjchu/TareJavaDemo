package a02.day03;
//������
public class Tetromino {
	Cell[] cells;//����1����������
	Tetromino(){//���캯��
		cells = new Cell[4];
	}
	void print(){//��ӡ���������и��ӵ�����
		for(int i = 0; i < cells.length; i ++){
			cells[i].getCellInfo();
		}
		System.out.println();
	}
	void drop(){//����1��
		for(int i = 0; i < cells.length; i++){
			cells[i].row ++;
		}
	}
	void moveLeft(){//����1��
		for(int i = 0; i < cells.length; i++){
			cells[i].col --;
		}
	}
	void moveRight(){//����1��
		for(int i = 0; i < cells.length; i++){
			cells[i].col ++;
		}
	}
}
