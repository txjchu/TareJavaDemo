package oo.day03;
//super��ʾ
public class SuperDemo {
	public static void main(String[] args) {
		Boo o = new Boo();
		Aoo b = new Boo();
		Aoo a = new Aoo();
	}
}

//����:ÿ���඼��һ���޲ι���
class Coo{
	Coo(int a){
		
	}
}
class Doo extends Coo{
	Doo(){
		super(5); //���ø�����вι���
		          //���Լ����˸��๹�죬����Ĭ���ṩsuper()��
	}
}



class Aoo{
	Aoo(){
		System.out.println("���๹��");
	}
}
class Boo extends Aoo{
	Boo(){
		super();
		System.out.println("���๹��");
	}
}


