package day02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 读写基本类型数据
 * @author Administrator
 *
 */
public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf
			= new RandomAccessFile(
				"test.dat","rw"	
			);
		/*
		 * RAF是基于指针进行读写操作的:
		 * 总是在指针当前位置进行读写字节，每当进行
		 * 完读或者写后，指针会自动向后移动。
		 * 刚创建好的RAF指针默认位置为0,就是指向
		 * 文件的第一个字节。
		 * long getFilePointer()
		 * 获取当前指针位置
		 */
		long pos = raf.getFilePointer();
		System.out.println("pos:"+pos);//0
		
		
		//将int最大值写出
		int max = Integer.MAX_VALUE;
		/*
		 * 要连续写出4个字节才可以将int值写出
		 *                            vvvvvvvv
		 * 00000000 00000000 01111111 11111111 11111111 11111111
		 */
		raf.write(max>>>24);
		System.out.println("pos:"+raf.getFilePointer());
		
		raf.write(max>>>16);
		raf.write(max>>>8);
		raf.write(max);
		
		System.out.println("pos:"+raf.getFilePointer());
		
		//连续写出4个字节，将int值写出
		raf.writeInt(max);
		
		System.out.println("pos:"+raf.getFilePointer());
		
		raf.writeLong(123L);
		
		System.out.println("pos:"+raf.getFilePointer());
		
		raf.writeDouble(123.123);
		System.out.println("pos:"+raf.getFilePointer());
		
		/*
		 * int readInt()
		 * 该方法会连续读取4个字节，并转换为int
		 * 值返回。由于不能再依靠返回-1表示读取到
		 * 文件末尾，所以该方法若读取到末尾会抛出
		 * 一个异常EOFException
		 * EOF(end of file)
		 * 
		 */
		raf.seek(0);
		System.out.println("pos:"+raf.getFilePointer());
		int i = raf.readInt();
		System.out.println(i);
		System.out.println("pos:"+raf.getFilePointer());
		
		//直接读double
		raf.seek(16);
		double d = raf.readDouble();
		System.out.println(d);
		System.out.println("pos:"+raf.getFilePointer());
		raf.close();
	}
}









