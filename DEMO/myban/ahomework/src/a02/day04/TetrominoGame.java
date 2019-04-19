package a02.day04;

import java.util.Scanner;

public class TetrominoGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T t = new T(0, 4);
		t.print();
		printTetromino(t);
		int num;
		while(true){			
			System.out.println("1 -- 下落，2 -- 向左，3 -- 向右，0 -- 退出");
			num = scan.nextInt();
			if(num == 0){
				System.out.println("谢谢尝试！");
				break;
			}else{
				switch(num){
				case 1:
					t.drop();
					break;
				case 2:
					t.moveLeft();
					break;
				case 3:
					t.moveRight();
					break;
				}				
			}
			printTetromino(t);
		}
		scan.close();		
/*
		T t = new T(2, 2);
		t.print();
		t.drop();
		t.print();
		printTetromino(t);
		Tetromino j = new J(3, 3);
		j.print();
		j.moveLeft();
		j.print();
		j.drop();//子类的引用可以调用父类中的方法，父类的引用不能调用子类中的方法，不看对象是子类还是父类
		printTetromino(j);
*/		
	}
	public static void printTetromino(Tetromino tetro){
		Cell[] cells = tetro.cells;
		int totalrow = 10;//总共10行
		int totalcol = 20;//总共20列
		for(int row = 0; row < totalrow; row++){
			for(int col = 0; col < totalcol; col++){
				boolean flag = true;
				for(int i = 0; i < cells.length; i++){
					if(row == cells[i].row && col == cells[i].col){
						flag = false;
						break;
					}
				}
				if(flag){
					System.out.print("-");
				}else{
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
