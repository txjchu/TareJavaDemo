package oo.day01;
//������Ĳ�����
public class CellTest {
	public static void main(String[] args) {
		/*
		Cell c = new Cell(); //�������Ӷ���
		c.row = 2; //�к�Ϊ2
		c.col = 5; //�к�Ϊ5
		
		c.drop(); //����1��
		c.moveLeft(3); //����3��
		String str = c.getCellInfo(); //��ȡ�������к�
		System.out.println(str); //3,2
		*/
		
		Cell c = new Cell(); //�������Ӷ���
		c.row = 2;
		c.col = 5;
		
		System.out.println("ԭʼ:");
		print(c); //Cell cc=����(2,5);
		
		c.drop(); //����1��
		System.out.println("�����:");
		print(c); //Cell cc=����(3,5);
		
		c.moveLeft(3); //����3��
		System.out.println("���ƺ�:");
		print(c); //Cell cc=����(3,2);
		
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








