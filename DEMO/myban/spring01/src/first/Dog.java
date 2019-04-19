package first;

import java.io.Serializable;

import factory.Animal;

/**
 * 
 * @author Administrator
 *
 */
public class Dog  implements Serializable{	//----继承序列化接口
	public Dog(){
		System.out.println("创建了一只狗");
	}
	public void cry(){
		System.out.println("汪汪汪~~~");
		
	}
}
