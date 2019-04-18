package oo.day01;
//格子类的测试类
public class CellTest {
	public static void main(String[] args) {
		/*
		Cell c = new Cell(); //创建格子对象
		c.row = 2; //行号为2
		c.col = 5; //列号为5
		
		c.drop(); //下落1格
		c.moveLeft(3); //左移3格
		String str = c.getCellInfo(); //获取格子行列号
		System.out.println(str); //3,2
		*/
		
		Cell c = new Cell(); //创建格子对象
		c.row = 2;
		c.col = 5;
		
		System.out.println("原始:");
		print(c); //Cell cc=对象(2,5);
		
		c.drop(); //下落1格
		System.out.println("下落后:");
		print(c); //Cell cc=对象(3,5);
		
		c.moveLeft(3); //左移3格
		System.out.println("左移后:");
		print(c); //Cell cc=对象(3,2);
		
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








