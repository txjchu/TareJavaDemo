package a02;
//J型
public class J {
	Cell[] cells;
	J(){//无参构造
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
	void drop(){//下落
		for(int i = 0; i < cells.length; i++){
			cells[i].row ++;//所有格子横坐标加1
		}
	}
	void moveLeft(){//左移1格
		for(int i = 0; i < cells.length; i++){
			cells[i].col --;//所有格子纵坐标列减1
		}
	}
	void moveRight(){//右移1格
		for(int i = 0; i < cells.length; i++){
			cells[i].col ++;//所有格子纵坐标列加1
		}
	}
//	String getCellsInfo(){//【】自己
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
