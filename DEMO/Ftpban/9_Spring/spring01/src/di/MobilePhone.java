package di;

public class MobilePhone {
	private String name;
	private int price;
	public MobilePhone(String name, int price) {
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return name + " " + price;
	}
	
	
}
