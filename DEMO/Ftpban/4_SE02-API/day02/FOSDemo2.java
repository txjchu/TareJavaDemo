package day02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 追加写操作的文件字节输出流
 * @author Administrator
 *
 */
public class FOSDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * 重载构造方法，允许传入第二个参数，是一个
		 * boolean值，若该值为true，则是追加写操作
		 * 那么通过该流写出的内容会追加在该文件末尾。
		 */
		FileOutputStream fos
			= new FileOutputStream(
				"fos.txt",true	
			);
		
		String str = "摩擦摩擦.";
		
		byte[] data = str.getBytes("GBK");
		fos.write(data);
		
		fos.close();
	}
}





