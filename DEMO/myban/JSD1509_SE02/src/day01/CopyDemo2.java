package day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile提供了批量读写数据的方法
 * 
 * int read(byte[] data)
 * 该方法会一次尝试读取给定的字节数组data的总长度的字节量，
 * 并将读取回来的数据装入到该数组中，返回值为实际读取到得字节量，
 * 若返回值为-1，则表示i这次没有读取到任何数据（文件末尾了）。
 * 
 * void write(byte[] data)
 * 一次性将给定的字节数组中的所有字节全部写出。
 * 
 * void write(byte[] data,int offset,int len)
 * 一次性将给定的字节数组中从offset处开始连续len 个字节写出。
 * （写出字节数组中的部分内容）
 * 
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src 
			= new RandomAccessFile("inst.exe", "r");
		RandomAccessFile desc
			= new RandomAccessFile("inst_copy.exe","rw");
		
		int len=-1;
		byte[] data=new byte[1024*10];
		long start = System.currentTimeMillis();
		while((len=src.read(data))!=-1){
			desc.write(data,0,len);
		}
		long end = System.currentTimeMillis();
		System.out.println("复制完毕！共耗时："+(end-start));
		
		src.close();
		desc.close();
	}
}
