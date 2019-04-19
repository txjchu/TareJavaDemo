package day03.copy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 作为高级流自行处理其他流
 * PrintWriter提供的构造方法允许我们传入字符流，也可以传入字节流。
 * 但是直接包装字节流的弊端是不能指定字符流。
 * 
 * 但是以上方式创建的PrintWriter具有自动行刷新功能。
 * @author Administrator
 *
 */
public class PrintWriterDemo02 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("pw.txt");
		/*
		 * 直接包装字节流将不能指定字符集
		 */
//		PrintWriter pw = new PrintWriter(fos);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		PrintWriter pw = new PrintWriter(osw);
		pw.println("我爱某某苍老师");
		pw.close();
		
	}
}














