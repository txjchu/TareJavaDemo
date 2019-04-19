package day03;
/**
 * Cell类
 * @author Administrator
 *
 */
public class Cell {
	int row;
	int col;
	public Cell(int x, int y){
		this.row = x; 
		this.col = y;
	}
	public void drop(){
		this.row ++;
	}
	@Override
	//重写toString方法
	public String toString() {
		
		return "["+ row +","+ col +"]";
	}
	@Override
	//重写equals方法
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}
		if(obj instanceof Cell){
			Cell cell = (Cell) obj;//强转类型
			return (cell.row == this.row && cell.col == this.col);
		}
		return false;
	}
	
	
}
