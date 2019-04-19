package day03;
/**
 * Cell��
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
	//��дtoString����
	public String toString() {
		
		return "["+ row +","+ col +"]";
	}
	@Override
	//��дequals����
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}
		if(obj instanceof Cell){
			Cell cell = (Cell) obj;//ǿת����
			return (cell.row == this.row && cell.col == this.col);
		}
		return false;
	}
	
	
}
