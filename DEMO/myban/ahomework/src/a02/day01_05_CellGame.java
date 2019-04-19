package a02;

import java.util.Scanner;

/**
 * 格子游戏（加用户控制）
 * @author Administrator
 *
 */
public class day01_05_CellGame {
	public static void main(String[] args) {
		System.out.println("格子游戏开始！");
		Cell c = new Cell();
		c.row = 3;
		c.col = 3;
		printCell(c);
		System.out.println("输入：1--向下，2--向左，3--向右，0--退出！");
		Scanner scan = new Scanner(System.in);
		int cmd = scan.nextInt();
		while(cmd != 0){
			switch(cmd){
			case 1:
				c.drop();
				break;
			case 2:
				c.moveLeft();
				break;
			case 3:
				c.moveRight();
				break;
			}
			printCell(c);
			System.out.println("输入：1--向下，2--向左，3--向右，0--退出！");
			cmd = scan.nextInt();//接收下一次用户输入的数字，如果没有这句代码，则会一直循环判断cmd
		}
		System.out.println("游戏结束！");
		scan.close();
	}
	//打印格子Cell的方法
	public static void printCell(Cell c){
		int totalRow = 10;//总共10行
		int totalCol = 20;//总共20列
		String str = c.getCellInfo();
		System.out.println("Cell的坐标是（"+ str +"）");
		//打印场地
		for(int row = 0; row < totalRow; row++){
			for(int col = 0; col < totalCol; col++){
				if(row == c.row && col == c.col){
					System.out.print("*");
				}else{
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
}
