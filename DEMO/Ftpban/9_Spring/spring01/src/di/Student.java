package di;

public class Student {
	private Computer computer;
	private MobilePhone mp;
	
	@Override
	public String toString() {
		return computer + " " + mp;
	}
	public Computer getComputer() {
		return computer;
	}
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	public MobilePhone getMp() {
		return mp;
	}
	public void setMp(MobilePhone mp) {
		this.mp = mp;
	}
	
}
