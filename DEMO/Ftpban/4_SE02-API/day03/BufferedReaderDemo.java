package day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.BufferedReader
 * 缓冲字符输入流，特点:以行为单位读取字符串
 * 
 * @author Administrator
 *
 */
public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 将当前源程序内容读取出来后输出到
		 * 控制台上
		 */
		//负责从文件中读取字节
		FileInputStream fis
			= new FileInputStream(
				"src"+File.separator+
				"day03"+File.separator+
				"BufferedReaderDemo.java"	
			);
		//负责将字节转换为字符
		InputStreamReader isr
			= new InputStreamReader(fis);
		//负责将一行字符串读取并返回
		BufferedReader br
			= new BufferedReader(isr);
		
		/*
		 * String readLine()
		 * 缓冲字符输入流的该方法会连续读取
		 * 若干个字符，直到读取到换行符为止，
		 * 然后将换行符之前的所有字符转换为
		 * 一个字符串后返回。若返回值为null
		 * 说明没有数据可以读取了(文件末尾)
		 */
		String line = null;
		while((line = br.readLine())!=null){
			System.out.println(line);
		}
		
		br.close();
	}
}








