package oo.day01;
//������
public class Cell {

	
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
	String getCellInfo(){//��ȡ�����кź��к�
		return row+","+col;//�������к�
	}
	
}
