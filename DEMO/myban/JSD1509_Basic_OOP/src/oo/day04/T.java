package oo.day04;
//T型类
public class T extends Tetromino{
	T(){
		this(0,0);
	}
	T(int row,int col){//构造方法
		super(); 	//调用父类的无参构造方法--默认的
        			//super调父类构造必须位于子类构造的第一句
 //创建格子数组对象
		cells[0] = new Cell(row,col); //创建格子对象
		cells[1] = new Cell(row,col+1);
		cells[2] = new Cell(row,col+2);
		cells[3] = new Cell(row+1,col+1);
	}	

	void print(){ //输出格子行列号
		System.out.println("I am a T:");
		super.print();//调用父类的print()方法
	}
{}

{}

{}

{}

}		
