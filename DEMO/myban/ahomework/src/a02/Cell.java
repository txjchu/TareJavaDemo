package a02;
/**
 * day01_04_Cell
 * ������
 * @author Administrator
 *
 */
public class Cell {
	int row;//��
	int col;//��
	Cell(){//�޲ι���
		this(0,0);
	}
	Cell(int row){
		this(row,row);//�����е��÷���������Cell(int ,int)����
	}
	Cell(int row, int col){//�вι��죬�������ƺͳ�Ա����������ͬ��������this.
		this.row = row;//�ֲ������ͳ�Ա����ͬ��ʱ��this����ʡ��
		this.col = col;
	}
	Cell(Cell cell){//case��ϰ03�������������Խ�cell1��ֵ��cell2
		this(cell.row,cell.col);
	}
	void drop(){//�����ƶ�1��
		row++;
	}
	void drop(int row){//����drop()������
		this.row +=row;
	}
	void moveRight(){
		col++;//�����ƶ�1��
	}
	void moveRight(int n){
		col += n;//�����ƶ�n��
	}
	void moveLeft(){//�����ƶ�
		col --;//�����ƶ�1��
	}
	void moveLeft(int col){//����moveLeft()���������ϲ���
		this.col -=col;
	}
	String getCellInfo(){//��ȡ���ӵ����к�
		return "("+ row +","+ col +")";
	}
}
