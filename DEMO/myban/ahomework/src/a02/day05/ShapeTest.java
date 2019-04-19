package a02.day05;
//��������󷽷���ϰ������Ƚ�ͼ������Ĵ�С
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
	public static void maxArea(Shape[] shapes){//�Ƚ�ͼ������Ĵ�С
		double max = shapes[0].area();//����shapes[0]ͼ�ε�������
		int maxIndex = 0;//�����������ͼ�ε��±�
		for(int i = 0; i < shapes.length; i++){
			if(max < shapes[i].area()){
				max = shapes[i].area();
				maxIndex = i;
			}
		}
		System.out.println("�������ͼ���ǣ�ͼ��"+ (maxIndex+1) +"�����Ϊ��"+ max);
	}
}

abstract class Shape{//�����࣬ͼ����
	protected double c;//�ܳ�
	public abstract double area();//���󷽷�������ͼ������ķ���
}
class Circle extends Shape{//Բ���࣬�̳�ͼ����
	public Circle(double c){
		this.c = c;
	}
	@Override
	public double area() {//��д����ķ���������Բ�ε�����ķ���	
		return 0.0796 * c * c;
	}	
}
class Square extends Shape{//�����࣬�̳�ͼ����
	public Square (double c){
		this.c = c;
	}
	public double area(){//��д����ķ�����������ε�����ķ���
		return 0.0625 * c * c;
	}
}
class Hexagon extends Shape{//�������࣬�̳�ͼ����
	public Hexagon(double c){
		
	}
	public double area(){//��д����ķ�������������������ķ���
		return 0.0721 * c * c;
	}
}