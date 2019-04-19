package a02;
//O����
public class O {
	Cell[] cells;//����1����������
	O(){//�޲ι���
		this(0, 0);
	}
	O(int row, int col){
		cells = new Cell[4];//������������4������
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col+1);
		cells[2] = new Cell(row+1, col+1);
		cells[3] = new Cell(row+1, col);
	}
	void drop(){//����1��ķ���
		for(int i = 0; i < cells.length; i++){
			cells[i].row ++;//�������м�1��ʾ����1��
		}
	}
	void moveLeft(){//����1��ķ���
		for(int i = 0; i < cells.length; i++){
			cells[i].col --;//�������в��䣬�������м�1
		}
	}
	void moveRight(){//����1��ķ���
		for(int i = 0; i < cells.length; i ++){
			cells[i].col ++;//�������в��䣬�������м�1
		}
	}
	void print(){//��ӡÿ�����ӵ�����
		String str = "";
		for(int i = 0; i < cells.length - 1; i++){
			str +=  cells[i].getCellInfo() ;
		}
		str +=  cells[cells.length - 1].getCellInfo();
		System.out.println(str);
	}
}
