package day02.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件流与RandomAccessFile的区别
 * 1.RAF对文件同时可以进行读写操作，但是流不行，读取只能使用输入流InputStream，写出只能用输出流OutputStream。
 * 2.RAF可以根据指针形式读写文件数据，所以只要指定位置，可以来回读写任意位置上的数据。
 *   但是流不行，流读取数据后，是不能再回到之前重新读的，没有操作指针的方法，除非创建新的流。写出也是一样。
 * @author Administrator
 *
 */
public class CopyDemo01 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("scrt.exe");
		FileOutputStream fos = new FileOutputStream("scrt_copy2.exe");
		byte[] buf = new byte[1024 * 10];//每次读写10KB
		int len = -1;
		while((len = fis.read(buf)) != -1){//若没有读取到文件末尾
			fos.write(buf, 0, len);
		}
		System.out.println("复制完毕！");
		fis.close();
		fos.close();
	}
}
















