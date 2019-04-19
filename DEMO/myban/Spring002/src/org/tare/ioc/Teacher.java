package org.tare.ioc;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
/**
 * ”√”⁄¡∑œ∞setter◊¢»Î
 * @author Administrator
 *
 */
@Component
public class Teacher implements Serializable {
	private Computer computer;

	public Computer getComputer() {
		return computer;
	}
	@Autowired
	public void setComputer(@Qualifier("cp") Computer computer) {
		this.computer = computer;
	}
	
}
