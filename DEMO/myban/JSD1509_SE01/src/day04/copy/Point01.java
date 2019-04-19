package day04.copy;
/**
 * 泛型，参数化类型。
 * 泛型可以约束类中：属性，方法的参数，返回值的类型。
 * @author Administrator
 *
 */
public class Point01<E> {
	//此处E仅代表某种类型，如：Integer,Double,Long, String...
	private E x;
	private E y;
	public Point01(E x, E y){
		super();
		this.x = x;
		this.y = y;
	}
	public E getX(){
		return x;
	}
	public void setX(E x){
		this.x = x;
	}
	public E getY(){
		return y;		
	}
	public void setY(){
		this.y = y;
	}
	public String toString(){
		return "("+ x +","+ y +")";
	}
	public boolean equals(Point01 p){
		if(p == null){//任何对象与空比较都返回false
			return false;
		}
		if(p == this){//任何对象与其自身比较都返回false
			return true;
		}
		if(p instanceof Point01){
			Point01 point = (Point01) p;//强转类型
			return this.x == p.x;
		}
		return false;//若不属于同一个类，则两个对象比较返回false
	}
}














