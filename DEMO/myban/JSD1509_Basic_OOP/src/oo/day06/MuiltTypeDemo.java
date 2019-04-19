package oo.day06;
//多态的演示
public class MuiltTypeDemo {
	public static void main(String[] args) {
		Aoo o1=new Boo();//向上造型
		//Boo o2=o1;//编译错误，Aoo大型，Boo小
		Boo o2=(Boo)o1;//o1指向的对象就是Boo类型
		Inter1 o3=(Inter1)o1;//向上造型，强制类型转换，o1所实现的对象指向了Inter1的接口
		//Coo o4=(Coo)o1;//强制类型转换，但是类型转换异常，转换不成功
		
		if(o1 instanceof Coo){    //false
			Coo o5=(Coo)o1;
		}
		
		Inter22 x = new y();
		Inter22 inter2 = x;
		y x2 = (y)x;
		x a =new y();
		y a1 = (y)a;
		x b = a1;
		x c = new z();
		
	}
}
interface Inter22{}
class x{}
class y extends x implements Inter22{}
class z extends x{}
interface Inter1{
	
}
class Aoo{
	
}
class Boo extends Aoo implements Inter1{
	
}
class Coo extends Aoo{
	
}
