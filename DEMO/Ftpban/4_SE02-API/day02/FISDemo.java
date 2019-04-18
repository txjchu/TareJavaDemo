package day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * java.io.FileInputStream
 * 文件字节输入流，是一个低级流。
 * 可以将数据从文件中读取出来。
 * @author Administrator
 *
 */
public class FISDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream(
				"fos.txt"
			);
		
		byte[] data = new byte[60];
		int len = fis.read(data);
		
		String str = new String(
			data,0,len,"GBK"
		);
		
		System.out.println(str);
		
		fis.close();
	}
}






