package a02;
//J��
public class J {
	Cell[] cells;
	J(){//�޲ι���
		this(0,0);
	}
	J(int row){
		this(row,row);
	}
	J(int row,int col){
		cells = new Cell[4];
		cells[0] = new Cell(row,col);
		cells[1] = new Cell(row,col+1);
		cells[2] = new Cell(row,col+2);
		cells[3] = new Cell(row+1,col+2);
		
	}
	void drop(){//����
		for(int i = 0; i < cells.length; i++){
			cells[i].row ++;//���и��Ӻ������1
		}
	}
	void moveLeft(){//����1��
		for(int i = 0; i < cells.length; i++){
			cells[i].col --;//���и����������м�1
		}
	}
	void moveRight(){//����1��
		for(int i = 0; i < cells.length; i++){
			cells[i].col ++;//���и����������м�1
		}
	}
//	String getCellsInfo(){//�����Լ�
//		String str = " ";
//		for(int i = 0; i < cells.length; i++){
//			str += cells[i].row +","+cells[i].col;
//		}
//		System.out.println(str);
//		return str;
//	}
	void print(){
		for(int i = 0; i < cells.length; i++){
			String str = cells[i].getCellInfo();
			System.out.print(str);
		}
		System.out.println();
	}
}
