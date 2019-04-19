package oo.day03;
//super演示
public class SuperDemo {
	public static void main(String[] args) {
		Boo o = new Boo();
		Aoo b = new Boo();
		Aoo a = new Aoo();
	}
}

//建议:每个类都做一个无参构造
class Coo{
	Coo(int a){
		
	}
}
class Doo extends Coo{
	Doo(){
		super(5); //调用父类的有参构造
		          //若自己调了父类构造，则不再默认提供super()了
	}
}



class Aoo{
	Aoo(){
		System.out.println("父类构造");
	}
}
class Boo extends Aoo{
	Boo(){
		super();
		System.out.println("子类构造");
	}
}


