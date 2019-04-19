package org.tare.ioc;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
/**
 * 用来练习@Resource 资源	result 结果	score 分数得分			
 * @author Administrator
 *
 */
@Component
public class Manager implements Serializable {
	private Computer computer;

	public Computer getComputer() {
		return computer;
	}
	@Resource(name = "cp")//注入对象为单例时，可省略name
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	
}
