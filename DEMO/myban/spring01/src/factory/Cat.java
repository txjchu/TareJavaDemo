package factory;

import java.io.Serializable;

import factory.Animal;

public class Cat extends Animal implements Serializable {
	public Cat (){
		System.out.println("用构造器，创建一个猫");
	}
	public void cry(){
		System.out.println("喵喵~~~");
	}
}
