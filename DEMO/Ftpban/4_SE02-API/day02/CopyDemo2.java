package day02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用缓冲流加快读写效率进行文件复制操作
 * 
 * java.io.BufferedOutputStream
 * java.io.BufferedInputStream
 * 
 * 缓冲字节输入输出流，是一对高级流。使用它处理
 * 其他流后，可以加快读写效率
 * @author Administrator
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream(
				"scrt.exe"	
			);
		BufferedInputStream bis
			= new BufferedInputStream(fis);
		
		
		FileOutputStream fos
			= new FileOutputStream(
				"scrt_copy.exe"	
			);
		BufferedOutputStream bos
			= new BufferedOutputStream(fos);
		
		int d = -1;
		/*
		 * 缓冲输入流的int read()方法:
		 * 该流内部维护一个缓冲区(字节数组)，然后
		 * 当我们调用read方法试图读取一个字节时，
		 * 该方法会从其处理的流中一次性读取一组字节
		 * 并存入缓冲区中，然后将第一个字节返回。
		 * 当我们再次调用该方法读取字节时，会继续将
		 * 数组中第二个字节返回。直到字节数组中的所有
		 * 字节全部被读取完毕后，才会再次通过其处理的
		 * 流一次性读取会另一组数据。
		 * 所以，缓冲流提高读取效率的方式仍然是提高
		 * 每次读取的数据量，减少了读取的次数达到的。
		 * 
		 * 
		 */
		while((d=bis.read())!=-1){
			bos.write(d);
		}
		
		System.out.println("复制完毕");
		/*
		 * 当我们进行了流的链接后(使用高级流处理另一个
		 * 流的这种形式就成为流的链接)
		 * 关闭时只需要关闭最外层的高级流即可。
		 * 因为高级流在关闭自身前会先将其处理的流
		 * 关闭。
		 */
		bis.close();
		bos.close();
		
		
	}
}











