package oo.day01;

public class Cell0 {
	int row;//ÐÐ
	int col;//ÁÐ
	void drop(){//µôÂä
		row++;//
	}
	void moveLeft(int n){
		col+=n;
	}
	void moveRight(int n){
		col-=n;
	}
	String getCellInto(){
		return row+","+col;
	}
}
