package ioc3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("programmer")
public class Programmer {
	private Computer computer;

	@Autowired
	public Programmer(
			@Qualifier("cp") Computer computer) {
		this.computer = computer;
	}

	@Override
	public String toString() {
		return "computer:" + computer;
	}
	
	
	
}
