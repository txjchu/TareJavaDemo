package oo.day01;
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
		
	Cell c=new Cell();
	c.row=2;
	c.col=5;
	
	System.out.println("ԭ�أ�");
	print(c);
	
	c.drop();
	System.out.println("���µ�һ���");
	print(c);
	
	c.moveLeft(3);
	System.out.println("������3���");
	print(c);	
	}
	
	public static void print(Cell cc){
		for (int i=0;i<20;i++){//��
			for(int j=0;j<10;j++){//��
				if(cc.col==j && cc.row==i){//����
					System.out.print("* ");
				}else{
					System.out.print("~ ");
				}
				
			}
			System.out.println();
		}
	}
}
