package oo.day02;
//������
public class Cell {
	
	int row;//�к�
	int col;//�к�
	Cell c=new Cell();
	
	Cell(){
		this(0,0);
	}
	Cell(int n){
		this(n,n);
	}
	Cell(int row,int col){
		this.row=row;
		this.col=col;
		
	}
	void drop(){	//�½�1��
		row++;		//�к�����1
	}
	void moveLeft(int n){ //����n��
		col-=n; //�кż�n
	}
	String getCellInfo(){ //��ȡ�����кź��к�
		return row+","+col; //�������к�
	}

	void drop(int n){ //����n��
		row+=n;
	}
	void moveLeft(){ //����1��
		col--;
	}
	
	/*
	int row;//�к�
	int col;//�к�
	
	void drop(){//����1��
		row++;//�к���1
	}
	void moveLeft(int n){  //����n��
		col-=n;//�кż�n
	}
	void moveRight(int n){  //����n��
		col+=n;//�кż�n
	}
	void drop(int n){
		row+=n;
	}
	void moveLeft(){
		col--;
	}
	String getCellInfo(){//��ȡ�����кź��к�
		return row+","+col;//�������к�
	}
	*/
}
