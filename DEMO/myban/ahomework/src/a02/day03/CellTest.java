package a02.day03;

public class CellTest {
	public static void main(String[] args) {
		Cell cell = new Cell();
		cell.moveRight(4);
		cell.getCellInfo();
		cell.drop();
		cell.getCellInfo();
		System.out.println();
		T t = new T(2,2);
		t.print();
//		t.drop();
//		t.print();
//		t.drop(2);
//		t.moveLeft(3);
//		t.moveRight(4);
//		t.print();
		J j = new J(3,3);
		j.print();
//		j.drop(5);
//		j.moveLeft(2);
//		j.moveRight(3);
		j.print();
	}
}
