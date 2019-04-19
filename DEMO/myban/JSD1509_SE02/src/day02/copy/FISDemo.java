package day02.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * java.io.FileInputStream
 * 文件字节输入流，是一个低级流，可以将数据从文件读取到java中。
 * @author Administrator
 *
 */
public class FISDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("fos.txt");
		byte[] data = new byte[100];
		int len = fis.read(data);//获取实际读取到的字节数
		String str = new String(data, 0, len, "GBK");
		System.out.println(str);
		fis.close();
	}
}














