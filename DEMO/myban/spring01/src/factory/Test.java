package factory;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal a = AnimalFactory.getAnimal("dog");
		a.cry();
		

	}

}
