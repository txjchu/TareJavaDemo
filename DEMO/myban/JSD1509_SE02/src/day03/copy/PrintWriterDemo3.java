package day03.copy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 自动行刷新
 * 每当调用println方法写出一个字符串内容后，就会自动调用flush，
 * 这样做可以提高写出的即时性，但是会降低写出效率。
 * @author Administrator
 *
 */
public class PrintWriterDemo3 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		FileOutputStream fos = new FileOutputStream("note.txt");//字节输出流
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");//将字节输出转换为字符串输出流
		/*
		 * 当创建PrintWriter时，若第一个参数传入的是一个流（无论字节还是字符流均可），那么就支持一个重载构造方法，
		 * 允许传入第二个参数，该参数是boolean值，若为true，则创建出来的PW具有自动行刷新功能。
		 */
		PrintWriter pw = new PrintWriter(osw, true);
		String line = null;
		while(true){
			line = scan.nextLine();//接收用户输入
			if("exit".equals(line)){
				break;
			}
			pw.println(line);
		}
		System.out.println("再见！");
		pw.close();
	}
}
















