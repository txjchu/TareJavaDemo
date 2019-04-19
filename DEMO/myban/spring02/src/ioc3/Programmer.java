package ioc3;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("programmer")	//--默认单例，容器会自动找到
public class Programmer implements Serializable {
	private Computer computer;
	
	@Autowired	//--写在构造器前面，表示让容器用构造方式注入
	public Programmer(@Qualifier("cp")Computer computer) {
		this.computer = computer;
	}

	@Override
	public String toString() {		
		return "computer:"+computer;
	}
	
}
