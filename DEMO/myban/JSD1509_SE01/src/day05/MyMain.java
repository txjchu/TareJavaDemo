package day05;
public class MyMain {
	public static void main(String[] args) {

		String str = "**java***java*****java*";
		String str1 = "java";
		int index = 0;
		while ((index = str.indexOf(str1, index)) != -1) {
			System.out.print(index+" ");
			index += str1.length();//��ָ������ƶ� 4 λ

		}
	}
}
