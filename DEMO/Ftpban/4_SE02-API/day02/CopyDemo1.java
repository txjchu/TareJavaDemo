package day02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流完成文件复制操作
 * 
 * 文件流与RandomAccessFile的区别
 * 1:RAF对文件同时可以进行读写操作，但是流不行，
 *   读取只能使用输入流，写出只能使用输出流。
 * 2:RAF可以根据指针形式读写文件数据，所以只要指定
 *   位置，可以来回读写任意位置上的数据。但是流不行，
 *   流读取数据后，是不能再回到之前重新读的，除非创建
 *   新的流。写出也是一样的。
 *     
 * 
 * @author Administrator
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream(
				"scrt.exe"	
			);
		
		FileOutputStream fos
			= new FileOutputStream(
				"scrt_copy2.exe"	
			);
		
		byte[] buf = new byte[1024*10];
		int len = -1;
		while((len = fis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		
		System.out.println("复制完毕");
		fis.close();
		fos.close();
	}
}








