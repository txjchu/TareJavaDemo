package day04;
/**
 * 泛型，参数化类型
 * 泛型可以约束类中:属性，方法的参数，返回值的类型。
 * @author Administrator
 *
 */
public class Point<E> {
	private E x;
	private E y;
	public Point(E x, E y) {
		super();
		this.x = x;
		this.y = y;
	}
	public E getX() {
		return x;
	}
	public void setX(E x) {
		this.x = x;
	}
	public E getY() {
		return y;
	}
	public void setY(E y) {
		this.y = y;
	}
	
	public String toString(){
		return "("+x+","+y+")";
	}
}


