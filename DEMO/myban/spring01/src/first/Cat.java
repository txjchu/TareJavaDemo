package first;

import java.io.Serializable;

import factory.Animal;

public class Cat  implements Serializable {
	public Cat (){
		System.out.println("�ù�����������һ��è");
	}
	public void cry(){
		System.out.println("����~~~");
	}
}
