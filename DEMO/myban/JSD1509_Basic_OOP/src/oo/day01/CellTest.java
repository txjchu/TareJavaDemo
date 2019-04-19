package oo.day01;
//格子类的测试类
public class CellTest {
	public static void main(String[] args) {
	/*
	Cell c=new Cell();//创建格子对象
	c.row=2;//行号为2
	c.col=5;//列号为5
	c.drop();//下落1格
	c.moveLeft(3);//左移3格
	String str=c.getCellInfo();//获取格子的行号列号
	System.out.println(str);//3，2
	*/
		
	Cell c=new Cell();
	c.row=2;
	c.col=5;
	
	System.out.println("原地：");
	print(c);
	
	c.drop();
	System.out.println("向下掉一格后：");
	print(c);
	
	c.moveLeft(3);
	System.out.println("向左移3格后：");
	print(c);	
	}
	
	public static void print(Cell cc){
		for (int i=0;i<20;i++){//行
			for(int j=0;j<10;j++){//列
				if(cc.col==j && cc.row==i){//？？
					System.out.print("* ");
				}else{
					System.out.print("~ ");
				}
				
			}
			System.out.println();
		}
	}
}
