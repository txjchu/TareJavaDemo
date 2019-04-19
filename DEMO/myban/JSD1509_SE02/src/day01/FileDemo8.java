package day01;

import java.io.File;
import java.io.FileFilter;

/**
 * 重载listFiles方法
 * File[] listFiles(FileFilter filter)
 * 返回当前目录中满足给定过滤器要求的所有子项，
 * 不满足条件的子项不会出现在返回的数组中。
 * 
 * FileFilter是一个接口，有一个抽象方法：
 * boolean accept()
 * 重写该方法来定义过滤条件，满足条件时该方法应当返回true。
 * @author Administrator
 *
 */
public class FileDemo8 {
	public static void main(String[] args) {
		/*
		 * 获取当前目录下所有名字以“.”开头的子项
		 */
		File dir=new File(".");
		if(dir.isDirectory()){
			/*
			 * 使用匿名内部类的形式创建一个文件过滤器实现类的实例
			 */
			FileFilter filter=new FileFilter(){
				public boolean accept(File file){
					//输出过滤器在过滤过程中的运行情况-----【★】
					System.out.println("正在过滤："+file.getName());
					return file.getName().startsWith(".");
				}
			};
			
			File[] subs=dir.listFiles(filter);
			for(File sub : subs){
				System.out.println("目录"+sub.getName());
			}
			
		}
		
	}
}
