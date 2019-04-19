package org.tare.ioc;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
/**
 * 用于练习@Autowired/@Qualifier注解指定依赖注入关系
 * @author Administrator
 *
 */
@Component
public class Programmer implements Serializable {
	

	private Computer computer;
	
	//构造器
	@Autowired
	public Programmer(@Qualifier("cp") Computer computer) {
		this.computer = computer;
	}
	
	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
}
