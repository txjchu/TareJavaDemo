package day02.copy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读取、写入文件，获取指针位置
 * @author Administrator
 *
 */
public class RandomAccessFileDemo002 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("test.dat","rw");
		raf.setLength(0);
		System.out.println("length:"+ raf.length());
		long pos = raf.getFilePointer();//获取当前指针下标
		System.out.println("pos:"+ pos);//pos:0
		
		int max = Integer.MAX_VALUE;//int最大值
		raf.write(max >>> 24);
		System.out.println("pos:"+ raf.getFilePointer());//pos:1
		raf.write(max >>> 16);
		raf.write(max >>> 8);
		System.out.println("pos:"+ raf.getFilePointer());//pos:3
		raf.write(max);			    //连续写入四次，才能把4字节的int类型数写入
		System.out.println("pos:"+ raf.getFilePointer());//pos:4
		
		raf.writeInt(max);
		raf.writeLong(123L);//写入L值		8字节
		System.out.println("pos:"+ raf.getFilePointer());//pos:12
		raf.writeDouble(123.123);//写入double类型的数	8字节
		System.out.println("pos:"+ raf.getFilePointer());//pos:20
		
		raf.seek(0);//指针移位到文件开头
		System.out.println("pos:"+ raf.getFilePointer());//pos:0
		int i = raf.readInt();//直接读取int数
		System.out.println(i);//2147483647
		System.out.println("pos:"+ raf.getFilePointer());//pos:4
		System.out.println("总字节："+ raf.length());//总字节：24
		raf.seek(16);//直接读取double		int = 4字节， long = 8字节
		double d = raf.readDouble();
		System.out.println(d);//123.123
		System.out.println("pos:"+ raf.getFilePointer());//pos:24
		raf.close();
	}
}
















