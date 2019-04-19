package demo;

public class Foo {
	public static void test(String str) {

		int check = 3;

		if (check == str.length()) {

			System.out.print(str.charAt(check -= 1) + ", ");

		} else {

			System.out.print(str.charAt(0) + ", ");

		}

	}

	public static void main(String[] args) {

		test("four");

		test("tea");

		test("to");
		String test = "tarena7cstp8info9";

		String[] tokens = test.split("\\d");

		for (String s : tokens) {

			System.out.print(s + " ");

		}

	}

}
