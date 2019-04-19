package oo.day05;
//查找一组图形的最大面积
public class ShapeTest {
	public static void main(String[] args) {
		//Shape s1=new Shape();//编译错误，抽象类不能被实例化
		//Shape s = new Square(1);//向上造型----
		
		Shape[] shapes=new Shape[4];//创建shape数组对象
		shapes[0]=new Circle(1);
		shapes[1]=new Circle(2);
		shapes[2]=new Square(1);
		shapes[3]=new Square(2);
		maxArea(shapes);//------???调用方法
	}
	
	//找最大面积
	public static void maxArea(Shape[] shapes){
		double max=shapes[0].area();//假设第一个图形面积最大
		int maxIndex=0;//最大面积图形的下标索引
		for(int i=0;i<shapes.length;i++){//遍历所有图形
			double area=shapes[i].area();//获取每个图形的面积
			if(area>max){//若比max还大
				max=area;//则改变max为area
				maxIndex=i;//改变最大面积的下标索引
			}
		}
		System.out.println("最大面积是"+max+",最大图形的下标是"+maxIndex);
	}
}
abstract class Shape{//抽象类  求面积
	protected double c; //周长
	public abstract double area();// 抽象方法
}
class Circle extends Shape{//圆形
	public Circle(double c){
		this.c=c;
	}
	public double area(){//重写抽象方法
		return 0.0796*c*c;
	}
}
class Square extends Shape{//方形
	public Square(double c){
		this.c=c;
	}
	public double area(){
		return 0.0625*c*c;
	}
}