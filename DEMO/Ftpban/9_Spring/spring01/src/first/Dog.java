package first;

import java.io.Serializable;

public class Dog implements Serializable{
  public Dog(){
	  System.out.println("创建了一只狗");
  }
  public void cry(){
	  System.out.println("汪汪...");
  }
}
