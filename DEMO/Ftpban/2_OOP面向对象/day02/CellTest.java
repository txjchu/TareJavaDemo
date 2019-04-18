package oo.day02;
//格子类的测试类
public class CellTest {
	public static void main(String[] args) {
		Cell c1 = new Cell();    //调无参构造
		Cell c2 = new Cell(3);   //调1个参数构造
		Cell c3 = new Cell(2,5); //调2个参数构造
		
		//Cell c4 = new Cell(2,5,7); //编译错误，Cell类没有3个参数的构造
		
		/*
		Cell c = new Cell();
		c.drop();
		c.drop(3);
		c.moveLeft();
		c.moveLeft(4);
		*/
	}
	
	//打墙+打格
	public static void print(Cell cc){
		for(int i=0;i<20;i++){ //行
			for(int j=0;j<10;j++){ //列
				if(cc.row==i && cc.col==j){ //行列匹配
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println(); //换行
		}
	}
	
}








