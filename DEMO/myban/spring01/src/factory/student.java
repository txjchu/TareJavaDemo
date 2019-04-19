package factory;

import java.io.Serializable;

public class student extends people implements Serializable {
	
	public student(){
		System.out.println("new出来一个学生");
	}
	@Override
	public void say() {
		System.out.println("我是一名学生");

	}

}
