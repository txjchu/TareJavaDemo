package a02.day06;
//�ڲ�����ϰ
public class InnerDemo {
	public static void main(String[] args) {
		Outer out = new Outer("33");
		out.printName();
	}
}
class Outer{//�ⲿ��
	private String name ;
	private Inner inn;
	public Outer(String str){
		this.name = str;
		this.inn = this.buildInner();
	}
	public void printName(){
		System.out.println(this.name);
		inn.showOuterName();
	}
	Inner buildInner(){
		return new Inner();//�ڲ������ͨ��ֻ�����ⲿ���д���
	}
	class Inner{//�ڲ���
		void showOuterName(){
			System.out.println(name);//Ĭ�����Outer.this
			System.out.println(Outer.this.name);
		}
	}
}