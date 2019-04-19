package factory;

import java.io.Serializable;

public class teacher extends people implements Serializable {

	public teacher(){
		System.out.println("new出来一个老师");
	}
	@Override
	public void say() {
		System.out.println("我是一个老师");

	}

}
