package a02;

public class aaa {
	public static void main(String[] args) {
		Outer out = new Outer("111");
		out.print();
	}
}
class Outer{//�ⲿ��
	private String name;
	private Inner inn;
	public Outer(String name){
		this.name = name;
		this.inn = this.buildInner(); 
	}
	public void print(){
		System.out.println("�ⲿ���������"+ name);
		inn.showOuterName();
	}
	Inner buildInner(){
		return new Inner();
	}
	class Inner{//�ڲ���
		void showOuterName(){
			System.out.println("�ڲ����������"+ Outer.this.name);
		}
	}
}