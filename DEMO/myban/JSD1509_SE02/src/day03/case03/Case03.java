package day03.case03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

import org.junit.Test;

/**
 * 案例
 * @author Administrator
 *
 */
public class Case03 {
	
	@Test//案例1	写出文本
	public void testPW() throws IOException{
		PrintWriter  pw = new PrintWriter("pw.txt");
		pw.println("大家好！");
		pw.println("hello,");
		pw.println("bye");
		pw.close();
	}
	
	@Test//案例2	使用字符输入流读取文件
	public void testBR() throws IOException{
		FileInputStream fis = new FileInputStream("pw.txt");//字节输入流
		InputStreamReader isr = new InputStreamReader(fis, "GBK");//将字节流转变为字符流
		BufferedReader br = new BufferedReader(isr);//缓冲字符输入流
//		int len = -1;
//		while((len = br.read()) != -1){
//			System.out.print((char)len);//按字节打印
//		}		
		//逐行打印
		String str = null;
		while((str = br.readLine()) != null){
			System.out.println(str);
		}
	}
	
	@Test//案例4	测试常见的异常
	public void testException(){
//		String str = null;
//		System.out.println(str.length());//NullPointerException
//		int[] arr = new int[2];
//		System.out.println(arr[2]);//ArrayIndexOfBoundsException
//		System.out.println(5 / 0);//ArithmeticException
		
//		Object obj = "hello";
//		Integer i = (Integer)obj;//ClassCastException
//		System.out.println(i);
		String str = "一二三";
		int a = Integer.parseInt(str);//NumberFormatException
		System.out.println(a);
	}
	
}









