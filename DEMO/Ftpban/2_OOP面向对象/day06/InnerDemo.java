package oo.day06;
//�ڲ�����ʾ
public class InnerDemo {
	public static void main(String[] args) {
		Mama m = new Mama();
		//Baby b = new Baby(); //��������ڲ�����ⲻ�߱��ɼ���
	}
}

class Mama{
	private String name;
	Baby createBaby(){
		return new Baby(); //�ڲ������ͨ��ֻ���ⲿ���д���
	}
	class Baby{
		void showMamaName(){
			System.out.println(name); //ǰ��Ĭ���и�Mama.this
			System.out.println(Mama.this.name);
			//System.out.println(this.name); //�������
		}
	}
}











