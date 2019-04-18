package factory;

import java.io.Serializable;

public class Dog extends Animal{
  public Dog(){
	  System.out.println("创建了一只狗");
  }
  public void cry(){
	  System.out.println("汪汪...");
  }
}
