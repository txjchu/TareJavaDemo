package oo.day02;
//������Ĳ�����
public class CellTest {
	public static void main(String[] args) {
		Cell c1 = new Cell();    //���޲ι���
		Cell c2 = new Cell(3);   //��1����������
		Cell c3 = new Cell(2,5); //��2����������
		
		//Cell c4 = new Cell(2,5,7); //�������Cell��û��3�������Ĺ���
		
		/*
		Cell c = new Cell();
		c.drop();
		c.drop(3);
		c.moveLeft();
		c.moveLeft(4);
		*/
	}
	
	//��ǽ+���
	public static void print(Cell cc){
		for(int i=0;i<20;i++){ //��
			for(int j=0;j<10;j++){ //��
				if(cc.row==i && cc.col==j){ //����ƥ��
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println(); //����
		}
	}
	
}








