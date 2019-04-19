package day01.copy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * 基于文件指针的形式读写文件数据。
 * 
 * 创建RandomAccessFile有两种常用模式：r:只读模式，rw:可读可写模式
 * @author Administrator
 *
 */
public class RandomAccessFile01 {
	public static void main(String[] args) throws InterruptedException, IOException {
		/*
		 * 想文件demo.dat中写入数据
		 * 
		 * 若有写数据的操作，那么创建时要使用读写模式，第二个参数为"rw"。
		 */
		File file = new File("demo.dat");//创建文件对象
		RandomAccessFile raf = new RandomAccessFile(file, "rw");//创建随机访问文件对象，参数2可读可写
		/*
		 * void  write(int i)
		 * 向文件中写入1个字节的2进制数据，写出的是给定的int值转换为2进制中的“低八位”
		 * 							  vvvvvvvv
		 * 00000000 00000000 00000000 00001010
		 */
		raf.write(10);
		/*
		 * 读写完毕后，一定要调用close()方法关闭，以释放资源。
		 */
		raf.close();
	}
}










