package day01.copy;

import java.io.File;
import java.io.FileFilter;

/**
 * 重载的listFiles方法：	File[] listFiles(FileFilter filter)		filter(过滤器)
 * 返回当前目录中满足给定过滤器要求的所有子项，不满足条件的子项不会出现在返回的数组中。
 * 
 * FileFilter是一个接口，有一个抽象方法：
 * boolean  accept(File file)
 * 重写该方法来定义过滤条件。满足条件时该方法应当返回true.
 * @author Administrator
 *
 */
public class FileDemo08 {
	public static void main(String[] args) {
		/*
		 * 获取当前目录下所有名字以“.”开头的子项
		 */
		File dir = new File(".");
		System.out.println(dir.isDirectory());
		if(dir.isDirectory()){//是目录
			/*
			 * 使用匿名内部类的形式创建一个文件过滤器，实现类的实例。
			 */
			FileFilter filter = new FileFilter(){
				@Override
				public boolean accept(File file) {
					System.out.println("正在过滤："+ file.getName());
					return file.getName().startsWith(".");
				}
			};
			File[] subs = dir.listFiles(filter);
			for(File sub : subs){
				System.out.println(sub.getName());
			}
				
		}
		
	}
}



















