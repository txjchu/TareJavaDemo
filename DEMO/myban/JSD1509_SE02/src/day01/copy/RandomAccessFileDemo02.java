package day01.copy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取文件数据
 * 
 * @author Administrator
 *
 */
public class RandomAccessFileDemo02 {
	public static void main(String[] args) throws IOException {
		/*
		 * 创建只读模式，不过创建读写模式也不影响读取。
		 */
		RandomAccessFile raf = new RandomAccessFile("demo.dat", "rw");
		/*
		 * int  read()
		 * 读取1个字节，并以int形式返回，但是该int值的2进制信息只有“低八位”有数据。
		 * 但若该int值表示的是-1,则表示读取到了文件末尾（1个字节的2进制是描述比例int的-1的。）
		 * 00000000 00000000 00000000 00001010
		 * 11111111 11111111 11111111 11111111
		 */
		int d = raf.read();
		System.out.println(d);//10
		System.out.println(raf.read());//-1
		long l = raf.getFilePointer();
		System.out.println("指针所在的位置："+ l);//1
		System.out.println("文件大小为："+ raf.length());
		
		File file = new File("demo.dat");
		System.out.println(file.length());
		File file1 = new File("demo.txt");				//一个英文字母1个字节，一个汉字2个字节
		System.out.println("demo.txt的大小为："+ file1.length());//demo.txt的大小
		RandomAccessFile raf1 = new RandomAccessFile("demo.txt", "r");
		while(raf1.read() != -1){
			raf1.read();
		}
		System.out.println("demo.txt读取完毕");			
		System.out.println("demo.txt文件中的指针位置："+ raf1.getFilePointer());
		
		raf1.close();
		raf.close();
	}
}












