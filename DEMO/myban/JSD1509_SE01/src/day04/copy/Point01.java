package day04.copy;
/**
 * ���ͣ����������͡�
 * ���Ϳ���Լ�����У����ԣ������Ĳ���������ֵ�����͡�
 * @author Administrator
 *
 */
public class Point01<E> {
	//�˴�E������ĳ�����ͣ��磺Integer,Double,Long, String...
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
		if(p == null){//�κζ�����ձȽ϶�����false
			return false;
		}
		if(p == this){//�κζ�����������Ƚ϶�����false
			return true;
		}
		if(p instanceof Point01){
			Point01 point = (Point01) p;//ǿת����
			return this.x == p.x;
		}
		return false;//��������ͬһ���࣬����������ȽϷ���false
	}
}














