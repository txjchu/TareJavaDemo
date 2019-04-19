package day01.copy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 复制文件  
 * 读写硬件的效率比较低，尤其是从硬盘、网络读取或写出数据。
 * 所以，一次读写一个字节，无疑会提高读写的次数，降低了读写的效率。为了提高效率，我们可以通过增大一次读写的数据量，
 * 来减少读写的次数，达到提高读写的效率。
 * @author Administrator
 *
 */
public class CopyDemo01 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src = new RandomAccessFile("scrt.exe", "r");//原来的资源
		RandomAccessFile desc = new RandomAccessFile("scrt_copy.exe", "rw");
		RandomAccessFile r = new RandomAccessFile("r.txt" , "rw");
		int d = -1;
		long start = System.currentTimeMillis();//后去当前时间点的毫秒数
		while((d = src.read()) != -1){//只要没有读取到文件末尾
//			desc.write(d);//写入从src中读取到的int数
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕，耗时："+ (end - start));
		
		r.close();
		src.close();
		desc.close();
	}
}

















