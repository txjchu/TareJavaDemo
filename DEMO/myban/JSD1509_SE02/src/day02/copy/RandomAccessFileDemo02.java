package day02.copy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读写基本类型数据
 * @author Administrator
 *
 */
public class RandomAccessFileDemo02 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");
		/*
		 * RAF是基于指针进行读写操作的：
		 * 总是在指针当前位置进行读写字节，每当进行完读或写后，指针会自动向后移动。
		 * 刚创建好的RAF指针默认位置为0，就是指向文件的第一个字节。
		 * long  getFilePointer()
		 * 获取当前指针位置
		 */
		long pos = raf.getFilePointer();
		System.out.println("pos:"+ pos);//pos:0
		//将int 最大值写出
		int max = Integer.MAX_VALUE;
		/*
		 * 要连续写出4个字节才可以将int值写出。(int基本类型是4字节，32位二进制)
		 * 00000000 00000000 01111111 11111111 11111111 11111111
		 * 												^^^^^^^^
		 * void  write(int d)
		 * 在当前指针位置开始写入一个字节。int是4字节，所以该方法只写入了int的低八位。
		 */
		raf.write(max >>> 24);//将max 向右移位24位，即只写入了最后8位（高八位）
		System.out.println("pos:"+ raf.getFilePointer());//pos:1
		raf.write(max >>> 16);
		raf.write(max >>> 8);
		System.out.println("pos:"+ raf.getFilePointer());//pos:3
		raf.write(max);		 //每次只写入int的低八位，连续写入4次，将int值全部写入。
		System.out.println("pos:"+ raf.getFilePointer());//pos:4
		
		raf.writeDouble(123.123);//double类型的数是8字节
		System.out.println("pos:"+ raf.getFilePointer());//pos:12
		
		/*
		 * int readInt()
		 * 该方法会连续读取4个字节，并转换为int值返回。由于不能再依靠返回-1表示读取到文件末尾，
		 * 所以该方法若读取到末尾会抛出一个异常EOFException(EOF: end of file).
		 */
		raf.seek(0);//指针移位到给定位置
		System.out.println("pos:"+ raf.getFilePointer());//pos:0
		int i = raf.readInt();
		System.out.println(i);//2147483647
		System.out.println("pos:"+ raf.getFilePointer());//pos:4
		raf.close();
	}
}














