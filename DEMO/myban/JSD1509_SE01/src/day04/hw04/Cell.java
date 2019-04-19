package day04.hw04;
/** 格子类 */
public class Cell {
	private int row;//行
	private int col;//列
	//构造方法
	public Cell(int row, int col){
		this.row = row;
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	@Override
	public String toString(){
		return row +","+ col;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
//	public boolean equals(Object o){
//		if(o == null){
//			return false;
//		}
//		if(this == o){
//			return true;
//		}
//		if(o instanceof Cell){
//			Cell c = (Cell) o;
//			return this.row == c.row && this.col == c.col;			
//		}
//		return false;
//	}
}
