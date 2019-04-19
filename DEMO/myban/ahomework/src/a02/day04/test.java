package a02.day04;

public class test {
	public static void main(String[] args) {
		Cell cell = new Cell(2);
		cell.getCellInfo();
		cell.drop();
		cell.getCellInfo();
		cell.moveLeft();
		cell.getCellInfo();
		cell.moveRight();
		cell.getCellInfo();
		cell.moveLeft();
		cell.getCellInfo();
		cell.moveLeft();
		cell.getCellInfo();
		System.out.println();
		T t = new T(2,2);
		t.print();
		t.moveLeft();
		t.print();
		t.moveLeft();
		t.print();
	}
}
