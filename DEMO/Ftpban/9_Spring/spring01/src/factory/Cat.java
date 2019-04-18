package factory;

import java.io.Serializable;

public class Cat extends Animal{

	public Cat() {
		System.out.println("创建了一只猫");
	}
	
	public void cry(){
		  System.out.println("喵喵...");
	  }
	
}
