package day03.exercise;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.junit.Test;

/**
 * 课后习题练习
 * @author Administrator
 *
 */
public class Exercise {
	
	@Test//习题1	测试Br和Pw字符输出输入流
	public void testBrAndPw() throws IOException{
		
		FileInputStream fis = new FileInputStream("pw.txt");
		InputStreamReader isr = new InputStreamReader(fis, "GBK");//字节流转变为字符流
		BufferedReader br = new BufferedReader(isr);//缓冲字符输入流
		
		FileOutputStream fos = new FileOutputStream("pw.txt", true);//追加模式
//		FileOutputStream fos = new FileOutputStream("pw.txt");//覆写模式
		OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
		PrintWriter pw = new PrintWriter(osw, true);//缓冲字符输出流
		String str = "";
		String all = "";
		while((str = br.readLine()) != null){
			all += str;
			System.out.println(all);
		}
		pw.println();//换行
		pw.println(all);
		System.out.println("复制完成！");
		br.close();
		pw.close();
	}
}
