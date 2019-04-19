package day02;

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
		RandomAccessFile raf
			= new RandomAccessFile("test.dat","rw");
		
		/*
		 * RAF是基于指针进行读写操作的：
		 * 总是在指针当前位置进行读写字节，每当进行完读或者写后，指针会自动向后移动。
		 * 刚创建好的RAF指针默认位置是0，就是指向文件的第一个字节。
		 * 
		 * long getFilePointer()
		 * 获取指针当前位置。
		 */
		long pos=raf.getFilePointer();
		System.out.println("指针当前位置pos："+pos);
//		System.out.println("指针当前位置pos："+raf.getFilePointer());
		
		//将int最大值写出
		int max= Integer.MAX_VALUE;
		/*
		 * 要连续写出4格字节才可以将int值写出
		 * 01111111 11111111 11111111 11111111
		 * 
		 */
		
		raf.write(max>>>24);		//1
		raf.write(max>>>16);		//1
		raf.write(max>>>8);			//1
		raf.write(max);				//1
		
		//连续写成4个字节，将int值写出
		/*
		 * int readInt()
		 * 该方法会连续读取4个字节，并转换为int值返回。
		 * 由于不能再依靠返回-1表示读取到文件末尾，所以该方法若读取到末尾会抛出
		 * 一个异常EOFException		EOF(end of file)
		 */
		
		raf.writeInt(max);			//4
		System.out.println("指针当前位置pos："+raf.getFilePointer());//8
		raf.writeLong(123L);		//8
		raf.writeDouble(123.123);	//8
		
		//直接读取double
		raf.seek(16);
		double d=raf.readDouble();
		System.out.println(d);
		System.out.println("指针当前位置pos："+raf.getFilePointer());
		System.out.println(raf.length());
		raf.close();
		
	}
}
