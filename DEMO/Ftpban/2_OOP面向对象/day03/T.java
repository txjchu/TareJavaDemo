package oo.day03;
//T����
public class T extends Tetromino {
	int a;
	T(){
		this(0,0);
	}
	T(int row,int col){
		super(); //���ø�����޲ι��췽��--Ĭ�ϵ�
		         //super�����๹�����λ�����๹��ĵ�һ��
		this.cells[0] = new Cell(row,col); //�������Ӷ���
		this.cells[1] = new Cell(row,col+1);
		this.cells[2] = new Cell(row,col+2);
		this.cells[3] = new Cell(row+1,col+1);
	}
}








