package oo.day02;
//T����
public class T {
	Cell[] cells;//��������
	T(){
		this(0,0);
	}
	T(int row,int col){
		this.cells=new Cell[4];//���������������
		this.cells[0]=new Cell(row,col);//�������Ӷ���
		this.cells[1]=new Cell(row,col+1);
		this.cells[2]=new Cell(row,col+2);
		this.cells[3]=new Cell(row+1,col+1);
	}
	void drop(){//����һ��
		for(int i=0;i<cells.length;i++){
			cells[i].row++;
		}
	}
	void moveLeft(){//����һ��
		for(int i=0;i<cells.length;i++){
			cells[i].col--;
		}
	}
	void moveRight(){//����һ��
		for(int i=0;i<cells.length;i++){
			cells[i].col++;
		}
	}
	void print(){//����������к�
		for(int i=0;i<cells.length;i++){
			String str=this.cells[i].getCellInfo();
			System.out.println(str);
		}
	}
}
