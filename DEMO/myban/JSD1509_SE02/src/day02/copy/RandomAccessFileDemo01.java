package day02.copy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * 读写字符串
 * @author Administrator
 *
 */
public class RandomAccessFileDemo01 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");//创建raf对象
		String str = "摩擦摩擦，是魔鬼的步伐！";//中文状态下的符号，在UTF-8中也是3个字节。
		/*
		 * 字符串提供了将内容转换为对应的编码的方法
		 * byte[]  getBytes()
		 * 按照当前系统默认的字符集将字符串内容转换为对应的一组字节数组。
		 * 
		 * GBK:国际编码，英文1个字节，中文2个字节。
		 * GB2312:繁体中文
		 * UTF-8:万国码，变长编码集，英文1个字节，中文3个字节
		 * ISO8859-1:一种欧洲的编码集，不支持中文。
		 */
//		byte[] date = str.getBytes();
		/*
		 * byte[]  getBytes(String charsetName)
		 * 根据给定的字符集将当前字符串内容转换为一组字节数组，字符集名称不区分大小写，但建议大写。
		 * 
		 */
		byte[] date = str.getBytes("UTF-8");
		raf.write(date);//写入date
		//将指针移动到文件最开始的第一个字节上
		raf.seek(0);
		/*
		 * 读取字符串的内容
		 */
		byte[] buf = new byte[50];
		int len = raf.read(buf);//读取raf文件中的字节，并放入buf中，返回实际独到的字节数len
		System.out.println(len);//36
		/*
		 * String 的构造方法
		 * String(byte[] d)
		 * 按照当前系统默认的字符集，将给定的字节数组中的所有字节转换为对应的一个字符串。
		 * 
		 * String(byte[] d, String charsetName)
		 * 按照给定的字符集将给定的字节数组中的所有字节转换为一个字符串。
		 * 
		 * String(byte[] d, int offset, int len, String charsetName)
		 * 将给定的字节数组中从offset处开始，连续len个字节以给定的字符集将其转换为一个字符集。
		 */
		String str1 = new String(buf, 0, len, "UTF-8");
		System.out.println(str1);
		raf.close();
	}
}


















