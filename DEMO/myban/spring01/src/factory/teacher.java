package factory;

import java.io.Serializable;

public class teacher extends people implements Serializable {

	public teacher(){
		System.out.println("new����һ����ʦ");
	}
	@Override
	public void say() {
		System.out.println("����һ����ʦ");

	}

}
