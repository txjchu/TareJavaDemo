package ioc3;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component("cp")	//----重新命名。默认是component。作用域默认单例singleton
public class Computer implements Serializable {

	public Computer() {
		System.out.println("Computer's 构造器被调用了....");
	}
	
}
