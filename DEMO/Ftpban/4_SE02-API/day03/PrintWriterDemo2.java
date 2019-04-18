package day03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 作为高级流自行处理其他流
 * PrintWriter提供的构造方法允许我们传入
 * 字符流，也可以传入字节流。
 * 但是直接包装字节流的弊端是不能指定字符集。
 * 
 * 但是以上方式创建的PrintWriter具有自动行刷新功能
 * @author Administrator
 *
 */
public class PrintWriterDemo2 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos
			= new FileOutputStream("pw.txt");
		/*
		 * 直接包装字节流将不能指定字符集
		 */
//		PrintWriter pw
//			= new PrintWriter(fos);
		
		OutputStreamWriter osw
			= new OutputStreamWriter(fos,"UTF-8");
		//包装字符流
		PrintWriter pw 
			= new PrintWriter(osw);
		
		pw.println("我爱达内苍老师!");
		
		pw.close();
	}
}











