package a02;
/**
 * ���������ϰ
 * @author Administrator
 *
 */
public class day01_04_Cell {
	public static void main(String[] args) {
		System.out.println("-----���Ƹ���Cell-----");
		Cell c = new Cell();//����1�����Ӷ���
		c.row = 3;
		c.col = 15;
//		String str = c.getCellInfo();
//		System.out.println("���ӵ�������"+ str);
		printCell(c);
		System.out.println("-----�����ƶ�1��-----");
		c.moveRight();
//		str = c.getCellInfo();
//		System.out.println("���ӵ�������"+ str);
		printCell(c);
		System.out.println("-----�����ƶ�3��-----");
		c.moveRight(3);
		printCell(c);
	}
	public static void printCell(Cell c){//��ӡ���ӵķ���
		int totalRow = 10;//�ܹ�10��
		int totalCol = 20;//�ܹ�20��
		String str = c.getCellInfo();
		System.out.println("Cell�������ǣ���"+ str +"��");
		//��ӡ����
		for(int i = 0; i < totalRow; i++){
			for(int j = 0; j < totalCol; j++){
				if(i == c.row && j == c.col){
					System.out.print("*");//��ӡָ���ĸ���
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
		int row;//��
		int col;//��
		void moveRigth(){//����1�еķ���
			col ++;
		}
		void moveRight(int n){//����n�еķ���
			col += n;
		}
		String getCellInfo(){//��ȡ���ӵ���������ķ���
			return row +","+ col;
		}
	}
*/
