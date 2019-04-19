package day01.copy;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.io.File
 * 该类的每一个实例可以表示硬盘上的一个文件或目录。
 * 通过访问该类可以：
 * 访问文件或目录的属性信息（文件名，大小，修改日期等），访问目下的子项，操作文件或目录（创建或删除文件，目录）
 * 但是不可以：
 * 不可以访问文件中保存的数据。
 * @author Administrator
 *
 */
public class FileDemo01 {
	public static void main(String[] args) {
		/*
		 * File在表示文件或目录时给的路径应当使用相对路径，这样可以避免平台差异性。
		 * 通常的，目录层级分隔符可以使用File提供的常量File.separator
		 * 
		 */
		File file = new File("."+ File.separator +"demo.txt");
		/*
		 * 获取文件的属性信息。
		 */
		String fileName = file.getName();
		System.out.println("文件的名字："+ fileName);//文件的名字：demo.txt
		//占用的磁盘空间，单位是字节
		long length = file.length();
		System.out.println("大小："+ length);//大小：2
		/*
		 * boolean isFile()
		 * 判断当前File对象表示的是否是文件。
		 */
		boolean isFile = file.isFile();
		System.out.println("是否是文件："+ isFile);//是否是文件：true
		//同样也可以判断是否是目录
		boolean isDir = file.isDirectory();
		System.out.println("是否是目录："+ isDir);//是否是目录：false
		//最后修改时间
		long time = file.lastModified();
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy年M月d日  HH:mm:ss"); 
		System.out.println(sdf.format(date));//2015年11月2日  10:45:15
		
		System.out.println("是否可读："+ file.canRead());//是否可读：true
		System.out.println("是否可写入："+ file.canWrite());//是否可写入：true
		System.out.println("是否可执行："+ file.canExecute());//是否可执行：true
		System.out.println("是否隐藏："+ file.isHidden());//是否隐藏：false
		
	}
}























