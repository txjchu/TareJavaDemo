package org.tare.ioc;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
/**
 * ������ϰ@Resource ��Դ	result ���	score �����÷�			
 * @author Administrator
 *
 */
@Component
public class Manager implements Serializable {
	private Computer computer;

	public Computer getComputer() {
		return computer;
	}
	@Resource(name = "cp")//ע�����Ϊ����ʱ����ʡ��name
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	
}
