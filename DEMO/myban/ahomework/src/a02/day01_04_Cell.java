package a02;
/**
 * 格子类的练习
 * @author Administrator
 *
 */
public class day01_04_Cell {
	public static void main(String[] args) {
		System.out.println("-----绘制格子Cell-----");
		Cell c = new Cell();//创建1个格子对象
		c.row = 3;
		c.col = 15;
//		String str = c.getCellInfo();
//		System.out.println("格子的坐标是"+ str);
		printCell(c);
		System.out.println("-----向右移动1列-----");
		c.moveRight();
//		str = c.getCellInfo();
//		System.out.println("格子的坐标是"+ str);
		printCell(c);
		System.out.println("-----向右移动3列-----");
		c.moveRight(3);
		printCell(c);
	}
	public static void printCell(Cell c){//打印格子的方法
		int totalRow = 10;//总共10行
		int totalCol = 20;//总共20列
		String str = c.getCellInfo();
		System.out.println("Cell的坐标是：（"+ str +"）");
		//打印场地
		for(int i = 0; i < totalRow; i++){
			for(int j = 0; j < totalCol; j++){
				if(i == c.row && j == c.col){
					System.out.print("*");//打印指定的格子
				}else{
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
}	
/*
public class Cell{
		int row;//行
		int col;//列
		void moveRigth(){//右移1列的方法
			col ++;
		}
		void moveRight(int n){//右移n列的方法
			col += n;
		}
		String getCellInfo(){//获取格子的行列坐标的方法
			return row +","+ col;
		}
	}
*/
