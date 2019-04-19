package day02;
/**
 * Í¼Æ¬ÖØÃüÃû
 * @author Administrator
 *
 */
public class StringDemo3 {
	public static void main(String[] args) {
		String imgName = "123.jpg";
		
		String[] arr = imgName.split("\\.");
		
		imgName = System.currentTimeMillis()+"."+arr[1];
		System.out.println(imgName);
				
	}
}


