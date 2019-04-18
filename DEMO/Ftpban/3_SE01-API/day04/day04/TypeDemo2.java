package day04;
/**
 * 泛型的实际类型是Object
 * 只是在使用时，编译器会检查传入的参数是否符合
 * 泛型要求，不符合则编译不通过，在获取泛型类型
 * 对应的值时会自动做类型转换而已。
 * 当没有指定泛型的具体类型是，就使用原型Object.
 * 
 * @author Administrator
 *
 */
public class TypeDemo2 {
	public static void main(String[] args) {
		Point<Integer> p = new Point<Integer>(1,2);
		//编译器会检查实参类型与泛型是否匹配
		p.setX(1);
		//会自动造型为Integer后返回。
		int x = p.getX();
		System.out.println(x);
		//以p1角度看，泛型使用原型Object
		Point p1 = p;
		//将x改变为String类型的值
		p1.setX("一");
		/*
		 * 由于以p的角度看x是Integer,所以虚拟机
		 * 在进行类型转换时将String值"一"转换为
		 * Integer时报错了!
		 */
		//ClassCastException
		x = p.getX();
		System.out.println(x);
		
	}
}








