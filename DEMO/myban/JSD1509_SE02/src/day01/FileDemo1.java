package day01;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.io.File
 * 该类的每一个实例可以表示硬盘上的一个文件或目录，
 * 通过该类可以：
 * 访问文件或目录的属性信息（文件名，大小，修改日期等）；
 * 访问目录下的子项；
 * 操作文件或目录（创建或删除文件，目录）；
 * 但是不可以：
 * 不可以访问文件中保存的数据。
 * @author Administrator
 *
 */
public class FileDemo1 {
	public static void main(String[] args) {
		File file=new File("."+File.separator+"demo.txt");
		/*
		 * File 在表示文件或目录时给的路径应当使用相对路径，
		 * 这样可以避免平台差异性。
		 * 通常的，目录层级分隔符可以使用File提供的常量File.separator
		 */
		
		/*
		 * 获取属性信息
		 */
		//获取文件或目录的名字
		String fileName=file.getName();
		System.out.println("名字："+fileName);
		
		//占用的磁盘空间，单位是字节
		long length=file.length();
		System.out.println("文件大小："+length);
		
		/*
		 * boolean isFile()
		 * 判断当前File对象表示的是否是文件
		 */
		boolean isFile=file.isFile();
		System.out.println("是否是文件："+isFile);
		
		//同样也可以判断是否为目录
		boolean isDir=file.isDirectory();
		System.out.println("是否是目录："+isDir);
		
		//最后的修改时间---【★】
		long time =file.lastModified();
		Date date=new Date(time);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy年M月d日 HH:mm:ss");
		System.out.println(sdf.format(date));
		
//		boolean file.canRead();
//		boolean file.canWrite();
//		boolean file.canExecute();
//		boolean 
	}
	
}
