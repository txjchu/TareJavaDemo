package a02;
//≤‚ ‘T,J–Õ
public class TJTest {
	public static void main(String[] args) {
		T t = new T(0,0);
		t.print();
		t.moveRight();
		t.print();
		t.moveLeft();
		t.print();
		t.moveLeft();
		t.print();
		t.moveLeft();
		t.print();
		J j = new J(3,4);
//		j.getCellsInfo();
		j.print();
		j.drop();
		j.print();
		j.moveLeft();
		j.print();
		j.moveRight();
		j.print();
		
		//≤‚ ‘O
		O o = new O(0,3);
		o.print();
		o.drop();
		o.print();
		o.moveLeft();
		o.print();
		o.moveRight();
		o.print();
	}
}
