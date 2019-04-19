package a02.day05;
//抽象类抽象方法练习，计算比较图形面积的大小
public class ShapeTest {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[2];
		shapes[0] = new Circle(2);
		shapes[1] = new Square(2);
		maxArea(shapes);
		Shape[] shapes1 = new Shape[3];
		shapes1[0] = new Circle(4);
		shapes1[1] = new Square(4);
		shapes1[2] = new Hexagon(4);
		maxArea(shapes1);
	}
	public static void maxArea(Shape[] shapes){//比较图形面积的大小
		double max = shapes[0].area();//假设shapes[0]图形的面积最大
		int maxIndex = 0;//储存面积最大的图形的下标
		for(int i = 0; i < shapes.length; i++){
			if(max < shapes[i].area()){
				max = shapes[i].area();
				maxIndex = i;
			}
		}
		System.out.println("面积最大的图形是：图形"+ (maxIndex+1) +"，面积为："+ max);
	}
}

abstract class Shape{//抽象类，图形类
	protected double c;//周长
	public abstract double area();//抽象方法，计算图形面积的方法
}
class Circle extends Shape{//圆形类，继承图形类
	public Circle(double c){
		this.c = c;
	}
	@Override
	public double area() {//重写父类的方法，计算圆形的面积的方法	
		return 0.0796 * c * c;
	}	
}
class Square extends Shape{//矩形类，继承图形类
	public Square (double c){
		this.c = c;
	}
	public double area(){//重写父类的方法，计算矩形的面积的方法
		return 0.0625 * c * c;
	}
}
class Hexagon extends Shape{//六边形类，继承图形类
	public Hexagon(double c){
		
	}
	public double area(){//重写父类的方法，计算六边形面积的方法
		return 0.0721 * c * c;
	}
}