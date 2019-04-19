package day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * 复制文件
 * 
 * 读写硬件的效率比较低，尤其是从硬盘，网络读取或写出数据。
 * 
 * 所以，一次对小额一个字节，无疑会提高读写的次数，降低了读写的效率。
 * 为了提高效率，我们可以通过增大一次读写的数据量，
 * 来减少读写的次数，达到提高读写的效率。
 * 
 * @author Administrator
 *
 */
public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src
			=new RandomAccessFile("inst.exe","r");
		RandomAccessFile desc
			=new RandomAccessFile("inst_copy.exe","rw");
		
		int d;			//---int d=-1;d等于多少都可以
		long start=System.currentTimeMillis();
		while((d=src.read())!=-1){
			desc.write(d);
		}
		long end=System.currentTimeMillis();
		System.out.println("复制完毕！耗时："+(end-start));
		
		src.close();
		desc.close();
	}
}
