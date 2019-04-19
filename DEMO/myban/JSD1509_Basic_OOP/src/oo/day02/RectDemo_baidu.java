package oo.day02;
//构造方法的演示----矩形面积--来自百度百科
public class RectDemo_baidu {
	public static void main(String[] args) {
		RectConstructor rect1 = new RectConstructor(10,20);//----如果没有无参构造的话，必须按照有参构造形式来初始化变量，需要传参。
		RectConstructor rect2 = new RectConstructor(3,6);
		double ar;
		ar = rect1.area();
		System.out.println("第一个矩形的面积"+ar);
		ar = rect2.area();
		System.out.println("第二个矩形的面积"+ar);
	}
}
class RectConstructor{
	double length;
	double width;
	double area(){//面积
		return length*width;
	}
	RectConstructor(){};	//----无参构造方法，
	
	RectConstructor(double length,double width){	//----有参构造方法
		this.length = length;
		this.width = width;
	}
}