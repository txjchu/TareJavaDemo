package oo.day01;

public class CellTest0 {
	public static void main(String[] args) {
		Cell0 c=new Cell0();
		c.row=2;
		c.col=5;
		
		System.out.println("ԭ�أ�");
		print(c);
		
		c.drop();
		System.out.println("������1��");
		print(c);
		
		c.moveLeft(2);
		System.out.println("�����ƶ�2��");
		print(c);
		

	}
	public static void print(Cell0 cc){
		for(int i=0;i<20;i++){
			for(int j=0;j<10;j++){
				if(cc.col==j && cc.row==i){
					System.out.print("* ");
				}else{
					System.out.print("~ ");
				}
			}
				System.out.println();
			
		}
		
	}
}
