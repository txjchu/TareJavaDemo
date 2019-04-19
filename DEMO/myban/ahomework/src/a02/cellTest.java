package a02;
/**
 * 测试格子位移
 * @author Administrator
 *
 */
public class cellTest {
	public static void main(String[] args) {
		Cell c = new Cell();
		c.row = 2;//第二行
		c.col = 5;//第五列
		Cell c2 = new Cell(c);
		print(c2,"测试构造方法");
		c.drop();//向下移动
		System.out.println(c.row);//打印c在多少行
		c.moveRight();
		System.out.println(c.col);//打印c在多少列
		c.moveRight(3);
		System.out.println(c.col);//打印现在c在多少列
		String str = c.getCellInfo();//获取格子c的行列号
		System.out.println(str);
		print(c,str);//打印格子c
		System.out.println("新格子");
		Cell cell = new Cell(4,11);
		str = cell.getCellInfo();
		System.out.println(str);
		System.out.println("------左移2格-------");
		cell.moveLeft(2);
		str = cell.getCellInfo();
		print(cell,str);
		System.out.println("------下落3格--------");
		cell.drop(3);
		str = cell.getCellInfo();
		print(cell,str);
	}
	public static void print(Cell c,String str){//打印格子的方法
		System.out.println(str);
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 20; j ++){
				if(i == c.row && j == c.col){
					System.out.print("*");
				}else{
					System.out.print("~");
				}
			}
			System.out.println();
		}
	}
}
