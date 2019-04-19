package a02.day05;
//day05_exercise01_子类重写父类的方法，子类对象调用的是谁的方法？指向子类对象的父类引用调用的是子类中重写后的方法
public class day05_01_fuzilei {
	public static void main(String[] args) {
		Vehicle vehicle = new RaceCar();
		RaceCar raceCar = new RaceCar();
		Car car = new RaceCar();
		Car car1 = new Car();
		Vehicle car2 = new Car();
		int n;
		n = vehicle.speed();
		System.out.println(n);
		n = raceCar.speed();
		System.out.println(n);
		System.out.println(car.speed());
		System.out.println(car1.speed());
//		Vehicle veh = new Vehicle();//交通工具类中没有构造方法
//		System.out.println(veh.speed());
		System.out.println(car2.speed());
	}
}
abstract class Vehicle{
	public int speed(){
		return 0;
	}
}
class Car extends Vehicle{//汽车类，继承交通工具类
	public int speed(){
		return 60;
	}
}
class RaceCar extends Car{//赛车类，继承汽车类
	public int speed(){
		return 150;
	}
}