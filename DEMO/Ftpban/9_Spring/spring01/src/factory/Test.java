package factory;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Animal a = new Dog();
		Animal a = AnimalFactory.getAnimal("cat");
		a.cry();
	}

}
