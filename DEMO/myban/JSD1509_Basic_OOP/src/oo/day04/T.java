package oo.day04;
//T����
public class T extends Tetromino{
	T(){
		this(0,0);
	}
	T(int row,int col){//���췽��
		super(); 	//���ø�����޲ι��췽��--Ĭ�ϵ�
        			//super�����๹�����λ�����๹��ĵ�һ��
 //���������������
		cells[0] = new Cell(row,col); //�������Ӷ���
		cells[1] = new Cell(row,col+1);
		cells[2] = new Cell(row,col+2);
		cells[3] = new Cell(row+1,col+1);
	}	

	void print(){ //����������к�
		System.out.println("I am a T:");
		super.print();//���ø����print()����
	}
{}

{}

{}

{}

}		
