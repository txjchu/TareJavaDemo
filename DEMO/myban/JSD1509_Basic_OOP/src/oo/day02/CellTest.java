package oo.day02;
//������Ĳ�����
public class CellTest {
	public static void main(String[] args) {
	/*
	Cell c=new Cell();//�������Ӷ���
	c.row=2;//�к�Ϊ2
	c.col=5;//�к�Ϊ5
	c.drop();//����1��
	c.moveLeft(3);//����3��
	String str=c.getCellInfo();//��ȡ���ӵ��к��к�
	System.out.println(str);//3��2
	*/
	Cell c1 = new Cell();    //���޲ι���
	Cell c2 = new Cell(3);   //��1����������
	Cell c3 = new Cell(2,5); //��2����������
		
	//Cell c4 = new Cell(2,5,7); //�������Cell��û��3�������Ĺ���
			
	/*
	Cell c=new Cell();
	c.row=3;
	c.col=3;
	c.drop();
	c.drop(1);
	*/
	}
	/*
	public static void print(Cell c){
		for(int i=0;i<20;i++){
			for(int j=0;j<10;j++){
				if(c.row==j && c.col==i){
					System.out.print("* ");
				}
				System.out.print("- ");
				
			}
			System.out.println();
		}
		
	}
	*/
	public static void print(Cell c){
		for(int i = 0; i < 20; i++){
			for(int j =0; j < 10; j++){
				if(c.row == i && c.col ==j){
					System.out.print("*");
				}else{
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
}
