package oo.day05;
//查找一组图形中的最大面积
public class ShapeTest {
	public static void main(String[] args) {
		//Shape s1 = new Shape(); //编译错误，抽象类不能被实例化
		//Shape s = new Square(1); //向上造型
		
		Shape[] shapes = new Shape[4]; //创建Shape数组对象
		shapes[0] = new Circle(1);
		shapes[1] = new Circle(2);
		shapes[2] = new Square(1);
		shapes[3] = new Square(2);
		maxArea(shapes);
	}
	//找最大面积
	public static void maxArea(Shape[] shapes){
		double max = shapes[0].area(); //假设第1个元素的面积最大
		int maxIndex = 0; //最大面积下标
		for(int i=1;i<shapes.length;i++){ //遍历所有图形
			double area = shapes[i].area(); //获取每一个图形的面积
			if(area>max){ //若比max还大
				max=area; //修改max的值为较大的
				maxIndex=i; //改变最大面积索引
			}
		}
		System.out.println("最大面积为:"+max+"，所在索引为:"+maxIndex);
	}
}

abstract class Shape{ //抽象类
	protected double c; //周长
	public abstract double area(); //抽象方法
}
class Circle extends Shape{ //圆形
	public Circle(double c){
		this.c = c;
	}
	public double area(){ //重写抽象方法
		return 0.0796*c*c;
	}
}
class Square extends Shape{ //方形
	public Square(double c){
		this.c = c;
	}
	public double area(){
		return 0.0625*c*c;
	}
}











