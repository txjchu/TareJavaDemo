package day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * 基于指针的形式读写文件数据。
 * 
 * 创建RandomAccessFile有两种常用模式:
 * 只读模式和读写模式。
 * @author Administrator
 *
 */
public class RandomAccessFileDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * 向文件demo.dat中写入数据
		 * 
		 * 若有写数据的操作，那么创建时要使用
		 * 读写模式，第二个参数为"rw".
		 */
		RandomAccessFile raf
			= new RandomAccessFile(
				"demo.dat","rw"
			);
		
		/*
		 * void write(int i)
		 * 向文件中写出1个字节的2进制数据
		 * 写出的是给定的int值转换为的2进制中的
		 * "低八位"
		 *                            vvvvvvvv
		 * 00000000 00000000 00000000 00001010
		 */
		raf.write(10);
		/*
		 * 读写完毕后，一定要调用close()方法
		 * 关闭，以释放资源
		 */
		raf.close();
		
		
	}
}










