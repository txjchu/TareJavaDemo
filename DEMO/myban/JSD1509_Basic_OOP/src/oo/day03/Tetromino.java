package oo.day03;
//TJ�ĸ��࣬�ĸ�ƴ��
public class Tetromino {//����
//	Cell[][] cells = new Cell[4][];
	
	
	
	Cell[] cells;//��������
	Tetromino(){
		cells=new Cell[4];//���������������------�������޲ι��췽�������ڳ�Ա�����ĳ�ʼ��
	}
	
//	Tetromino te =new Tetromino();	//��Ա�����Ķ��壬�Լ���ʼ��
	
	
	void drop(){ //����һ��
		for(int i=0;i<this.cells.length;i++){
			this.cells[i].row++;
		}
	}
	void moveLeft(){ //����һ��
		for(int i=0;i<cells.length;i++){
			cells[i].col--;
		}
	}
	void moveRight(){ //����һ��
		for(int i=0;i<cells.length;i++){
			cells[i].col++;
		}
	}
	void print(){ //����������к�
		for(int i=0;i<this.cells.length;i++){
			String str = this.cells[i].getCellInfo();
			System.out.println(str);
		}
	}
}
