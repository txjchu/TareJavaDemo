package factory;

import java.io.Serializable;

public class student extends people implements Serializable {
	
	public student(){
		System.out.println("new����һ��ѧ��");
	}
	@Override
	public void say() {
		System.out.println("����һ��ѧ��");

	}

}
