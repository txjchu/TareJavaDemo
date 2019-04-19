package day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 
 * @author Administrator
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		/*
		 * 读取文件数据
		 */
		RandomAccessFile raf 
			= new RandomAccessFile("demo.dat","r");
		/*
		 * int read()
		 * 读取1格字节，并以int形式返回。但是，该int值的2进制信息只有“低八位”有数据。
		 * 但若该int值表示的是-1，则表示读取到了，
		 * 文件末尾（1个字节的2进制是描述不了int的-1的。）
		 */
		int d=raf.read();
		System.out.println(d);
		
		raf.close();
	}
}
