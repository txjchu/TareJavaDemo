package oo.day02;
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
	Cell c1 = new Cell();    //调无参构造
	Cell c2 = new Cell(3);   //调1个参数构造
	Cell c3 = new Cell(2,5); //调2个参数构造
		
	//Cell c4 = new Cell(2,5,7); //编译错误，Cell类没有3个参数的构造
			
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
