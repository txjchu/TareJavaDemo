package a02.day05;
//day05_exercise01_������д����ķ��������������õ���˭�ķ�����ָ���������ĸ������õ��õ�����������д��ķ���
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
//		Vehicle veh = new Vehicle();//��ͨ��������û�й��췽��
//		System.out.println(veh.speed());
		System.out.println(car2.speed());
	}
}
abstract class Vehicle{
	public int speed(){
		return 0;
	}
}
class Car extends Vehicle{//�����࣬�̳н�ͨ������
	public int speed(){
		return 60;
	}
}
class RaceCar extends Car{//�����࣬�̳�������
	public int speed(){
		return 150;
	}
}