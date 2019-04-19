package oo.day05;
//����һ��ͼ�ε�������
public class ShapeTest {
	public static void main(String[] args) {
		//Shape s1=new Shape();//������󣬳����಻�ܱ�ʵ����
		//Shape s = new Square(1);//��������----
		
		Shape[] shapes=new Shape[4];//����shape�������
		shapes[0]=new Circle(1);
		shapes[1]=new Circle(2);
		shapes[2]=new Square(1);
		shapes[3]=new Square(2);
		maxArea(shapes);//------???���÷���
	}
	
	//��������
	public static void maxArea(Shape[] shapes){
		double max=shapes[0].area();//�����һ��ͼ��������
		int maxIndex=0;//������ͼ�ε��±�����
		for(int i=0;i<shapes.length;i++){//��������ͼ��
			double area=shapes[i].area();//��ȡÿ��ͼ�ε����
			if(area>max){//����max����
				max=area;//��ı�maxΪarea
				maxIndex=i;//�ı����������±�����
			}
		}
		System.out.println("��������"+max+",���ͼ�ε��±���"+maxIndex);
	}
}
abstract class Shape{//������  �����
	protected double c; //�ܳ�
	public abstract double area();// ���󷽷�
}
class Circle extends Shape{//Բ��
	public Circle(double c){
		this.c=c;
	}
	public double area(){//��д���󷽷�
		return 0.0796*c*c;
	}
}
class Square extends Shape{//����
	public Square(double c){
		this.c=c;
	}
	public double area(){
		return 0.0625*c*c;
	}
}