package day05;
/**
 * 当一个类的实例作为Map的key使用时，它的两个方法hashcode()与equals()的结果
 * 会影响HashMap的检索效率。
 * 若两个key的hashcode()值相同，但是equals比较不相同，则会在HashMap中产生链表，
 * 由于链表的遍历比较慢，所以若这样的元素在Map中非常多的话，
 * 那么会严重影响HashMap的查询效率。
 * 所以一个类的hashcode与equals应当成对重写。并注意该问题。
 * 
 * 成对重写的准则：
 * 1：当我们重写一个类的equals方法时，就应当连同重写hashCode()方法；
 * 2：一致性，即：当两个对象equals比较结果为true时，那么hashCode()返回的数字应当相等。
 * 3：hashCode()方法返回的数字应当是一个稳定的值，
 * 	多次调用该方法返回的数字应当相同，除非参与equals比较的属性值发生了改变。
 * 4：两个对象hashCode()值若相同，equals比较的结果最好相同，
 * 	若不相同则会影响HashMap性能。
 * 
 * @author Administrator
 *
 */
public class Key {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Key other = (Key) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
