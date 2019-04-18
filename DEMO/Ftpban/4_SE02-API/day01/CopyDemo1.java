package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 复制文件
 * 
 * 读写硬件的效率比较低，尤其是从硬盘，网络读取或
 * 写出数据。
 * 
 * 所以，一次读写一个字节，无疑会提高读写的次数，
 * 降低了读写的效率。为了提高效率，我们可以通过
 * 增大一次读写的数据量，来减少读写的次数,达到
 * 提高读写的效率。
 * 
 * 
 * @author Administrator
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src
			= new RandomAccessFile(
				"scrt.exe","r"
			);		
		RandomAccessFile desc
			= new RandomAccessFile(
				"scrt_copy.exe","rw"
			);
		int d = -1;
		long start = System.currentTimeMillis();
		while((d=src.read())!=-1){
			desc.write(d);
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕,耗时:"+(end-start));
		src.close();
		desc.close();
	}
}




