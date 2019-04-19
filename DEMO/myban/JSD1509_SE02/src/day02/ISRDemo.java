package day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * java.io.InputStreamReader
 * 字符输入流，特点是可以按照给定的字符集读取字符。
 * 
 * InputStreamReader和OutputStreamWriter
 * 被称为转换流：
 * 1.可以将字节流转换为字符流；
 * 2.可以转换字符集。
 * 
 * @author Administrator
 *
 */
public class ISRDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis
			= new FileInputStream("osw.txt");
		
		InputStreamReader isr		//----字节流转换为字符流
			= new InputStreamReader(fis,"UTF-8");
		
		int d=-1;
		while((d=isr.read())!=-1){
			char c=(char) d;
			System.out.print(c);
		}
		
		isr.close();
	}
}
