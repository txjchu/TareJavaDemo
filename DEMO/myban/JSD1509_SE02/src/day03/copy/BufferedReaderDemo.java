package day03.copy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.BufferedReader
 * 缓冲字符输入流，特点：以行为单位读取字符串。
 * @author Administrator
 *
 */
public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		//创建缓冲字符输入流对象
		//负责将原件上的数据以字节形式读取
		FileInputStream fis = new FileInputStream("src"+ File.separator +"day03"+
										File.separator +"BufferedReaderDemo.java");
		//负责将字节形式转换为字符形式
		InputStreamReader isr = new InputStreamReader(fis);
		//负责将一行字符串读取并返回
		BufferedReader br = new BufferedReader(isr);
		/*
		 * String  readLine()
		 * 缓冲字符流输入流的该方法会连续读取若干个字符，直到读取到换行符为止，然后将换行符之前的所有字符转换为一个字符串后返回，
		 * 若返回值为null，则说明读取到文件末尾空行处。
		 */
		String line = null;
		while((line = br.readLine()) != null){
			System.out.println(line);
		}
		br.close();
		
	}
}











