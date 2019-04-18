package oo.day04;
//重写的演示
public class OverrideDemo {
	public static void main(String[] args) {
	}
}

//父类大，子类小
//Tetromino t = new T(2,5); //向上造型(自动类型转换)
class Aoo{
	void show(){}
	double say(){return 0.0;}
	Aoo test(){return null;}
	Boo get(){return null;}
}
class Boo extends Aoo{
	public void show(){} //void时，必须相同
	double say(){return 0.0;} //基本类型时，必须相同
	//Boo test(){return null;} //正确的
	//Aoo get(){return null;} //编译错误
}









