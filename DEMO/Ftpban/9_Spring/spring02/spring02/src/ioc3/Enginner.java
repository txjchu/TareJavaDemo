package ioc3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("enginner")
public class Enginner {
	private Computer computer;

	public Computer getComputer() {
		return computer;
	}

	@Autowired
	public void setComputer(
			@Qualifier("cp") Computer computer) {
		this.computer = computer;
		System.out.println("computer×¢Èë³É¹¦");
	}

	@Override
	public String toString() {
		return "computer:" + computer;
	}
	
	
}
