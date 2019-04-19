package day02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * Writer 所有字符输出流的父类
 * 字符流都是高级流
 * 字符输出流可以以字符为单位写出数据。但是本质上还是要讲字符转换为字节后写出。
 * 
 * OutputStreamWriter的特点:
 * 可以按照给定的字符集将字符串转换为字节后写出。
 * @author Administrator
 *
 */
public class OSWDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos
			= new FileOutputStream("osw.txt");
		/*
		 * 常用构造方法：
		 * OutputStreamWriter(OutputStream o)
		 * 将给定的字节流包装为一个字符流，然后通过该流写出的字符串
		 * 都会按照系统默认的字符集转换为字节后写出。
		 * 
		 * 若要按照指定的字符集写出，可以使用下面的构造方法指定。
		 */
		
		OutputStreamWriter osw
			= new OutputStreamWriter(fos,"UTF-8");
		osw.write("摩擦摩擦");
		osw.write("一步两步");
		osw.write("似魔鬼的步伐");
		/*
		 * 关闭流是为了释放资源。
		 * 释放的是底层资源，向硬盘进行写操作的是底层的C库，调用Close的目的是释放
		 * 底层资源，流本身会被GC释放的。
		 * 
		 * 
		 */
		osw.close();
		
		
	}
}
