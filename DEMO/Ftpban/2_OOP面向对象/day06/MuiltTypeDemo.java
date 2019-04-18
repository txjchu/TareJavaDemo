package oo.day06;
//多态的演示
public class MuiltTypeDemo {
	public static void main(String[] args) {
		Aoo o1 = new Boo(); //向上造型
		Boo o2 = (Boo)o1; //o1指向的对象就是Boo类型
		Inter1 o3 = (Inter1)o1; //o1指向的对象实现了Inter1接口
		//Coo o4 = (Coo)o1; //类型转换异常
		if(o1 instanceof Coo){ //false
			Coo o5 = (Coo)o1;
		}
	}
}

interface Inter1{
}
class Aoo{
}
class Boo extends Aoo implements Inter1{
}
class Coo extends Aoo{
}









