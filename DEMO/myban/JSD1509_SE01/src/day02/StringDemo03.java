package day02;
/**
 * 图片重命名
 * @author Administrator
 *
 */
public class StringDemo03 {
	public static void main(String[] args) {
		String imgName = "123.jpg";
		String[] arr= imgName.split("\\.");//将字符串以.为界限分割，并储存到字符串数组中。
		imgName = System.currentTimeMillis()+ "." +arr[1];//将字符串中第一个对象用系统时间代替
		System.out.println(imgName);
	}
}













