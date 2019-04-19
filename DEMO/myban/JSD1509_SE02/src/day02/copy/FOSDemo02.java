package day02.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 追加写操作的文件字节输出流
 * @author Administrator
 *
 */
public class FOSDemo02 {
	public static void main(String[] args) throws IOException {
		/*
		 * 重载构造方法，允许传入第二个参数，是一个boolean值，若该值为true，则是追加写操作，
		 * 那么通过该流写出的内容会追加在该文件末尾。
		 */
		FileOutputStream fos = new FileOutputStream("fos.txt", true);
		String str = "摩擦摩擦.";
		byte[] data = str.getBytes("GBK");//将字符串转换为byte数组
		fos.write(data);
		
		FileInputStream fis = new FileInputStream("fos.txt");
		data = new byte[100];
		int len = fis.read(data);//按字节读取，所以读出来的byte不是真正意义上的内容，而是每个字节的底层2进制码。
		//将byte[]数组转换为String，可以采用String(byte[] b, int offset, int len, String charsetName)的构造方法
		String s = new 	String(data, 0, len, "GBK");
		System.out.println(s);
		
		fis.close();
		fos.close();
	}
}










