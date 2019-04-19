package day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFileDemo1
 * 基于指针的形式读写文件数据。
 * 
 * 创建RandomAccessFile有两种常见模式：
 * 只读模式和读写模式。
 * @author Administrator
 *
 */
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException {
		/**
		 * 向文件------------------补？
		 * 若有写数据的操作，那么创建时要使用读写模式，第二个参数为“rw”。
		 */
		RandomAccessFile raf 
			= new RandomAccessFile("demo.dat","rw");//当前目录下，或/**/**/**/demo.dat
		/*
		 * void write(int i)
		 * 向文件中写出1格字节的2进制数据
		 * 写出的是给定的int值转换为2进制中的“低八位”
		 */
		raf.write(10);
		/*
		 * 读写完毕后，一定要调用close（）方法关闭，以释放资源
		 */		
		raf.close();
		
		
	}
}
